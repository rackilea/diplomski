declare
    v_inline_view varchar2(32767);
    v_inline_views clob;
    v_inline_view_counter number := 0;
    v_and_expression varchar2(32767);
    v_query clob;

    v_sqls sys.odcivarchar2list;
    v_dynamic_query_counter number := 0;
begin
    --#1: Create inline views.
    --One for every combination of expression and distinct value, per column.
    for inline_views in
    (
        --Inline view for every possible expression for each column.
        select
            replace(q'[
            (
                select *
                from
                (
                    --Possible expressions.
                    select distinct
                        case
                            when operator is null then null
                            else ' AND %%COLUMN%% '||operator||' '||%%COLUMN%%
                        end %%COLUMN%%_expression
                    from
                    --All operators.
                    (
                        select '>'  operator from dual union all
                        select '<'  operator from dual union all
                        select '='  operator from dual union all
                        select null operator from dual
                    )
                    --All distinct values.
                    cross join
                    (
                        select distinct %%COLUMN%% from table1
                    )
                )
                --where %%COLUMN%%_expression is null or %%COLUMN%%_expression %%EXPRESSION_PERFORMANCE_EXCLUSIONS%%
            )
            ]', '%%COLUMN%%', column_name) inline_view
        from user_tab_columns
        where table_name = 'TABLE1'
            and column_name <> 'SCORE'
        order by column_name
    ) loop
        --Assign to temorary so it can be modified.
        v_inline_view := inline_views.inline_view;

        --#1A: Optimize inline view - throw out expressions if they don't return any positive results.
        declare
            v_expressions sys.odcivarchar2list;
            v_expressions_to_ignore varchar2(32767);
            v_has_score_gt_0 number;
        begin
            --Gather expressions for one column.
            execute immediate v_inline_view bulk collect into v_expressions;

            --Loop through and test each expression.
            for i in 1 .. v_expressions.count loop
                --Always keep the null expression.
                if v_expressions(i) is not null then
                    --Count the number of rows with a positive score.
                    execute immediate 'select nvl(max(case when score > 0 then 1 else 0 end), 0) from table1 where '||replace(v_expressions(i), ' AND ', null)
                    into v_has_score_gt_0;

                    --If the expression returns nothing positive then add it to exclusion.
                    if v_has_score_gt_0 = 0 then
                        v_expressions_to_ignore := v_expressions_to_ignore||','''||v_expressions(i)||'''';
                    end if;
                end if;
            end loop;

            --Convert it into an IN clause.
            if v_expressions_to_ignore is not null then
                --Remove comment, replace placeholder with expression exclusions.
                v_inline_view := regexp_replace(v_inline_view, '(.*)(--where)( .* )(%%EXPRESSION_PERFORMANCE_EXCLUSIONS%%)(.*)', '\1where\3 not in ('||substr(v_expressions_to_ignore, 2)||')');
            end if;
        end;

        --Aggregate and count inline views.
        if v_inline_view_counter <> 0 then
            v_inline_views := v_inline_views||'cross join';
        end if;

        v_inline_views := v_inline_views||v_inline_view;

        v_inline_view_counter := v_inline_view_counter + 1;
    end loop;

    --#2: Create an AND expression to combine all column expressions.
    select listagg(column_name||'_expression', '||') within group (order by column_name)
    into v_and_expression
    from user_tab_columns
    where table_name = 'TABLE1'
        and column_name <> 'SCORE';


    --#3: Create a that will create all possible expression combinations.
    v_query := 
    replace(replace(q'[
        --8281 combinations
        select '
            select
                '''||expressions||''' expression,
                nvl(sum(case when score > 0 then 1 else 0 end), 0) gt_0_score_count,
                nvl(sum(case when score <= 0 then 1 else 0 end), 0) le_0_score_count
            from table1
            where 1=1 '||expressions v_sql
        from
        (
            --Combine expressions
            select %%AND_EXPRESSION%% expressions
            from
            %%INLINE_VIEWS%%
        ) combined_expressions
    ]', '%%AND_EXPRESSION%%', v_and_expression), '%%INLINE_VIEWS%%', v_inline_views);

    --TEST: It might be useful to see the full query here.
    --dbms_output.put_line(v_query);

    --#4: Gather expressions.
    --With larger input you'll want to use a LIMIT
    execute immediate v_query
    bulk collect into v_sqls;

    --#5: Test each expression.  
    --Look for any queries that return the right number of rows.
    for i in 1 .. v_sqls.count loop
        declare
            v_expression varchar2(4000);
            v_gt_0_score_count number;
            v_le_0_score_count number;
        begin
            execute immediate v_sqls(i) into v_expression, v_gt_0_score_count, v_le_0_score_count;
            v_dynamic_query_counter := v_dynamic_query_counter + 1;

            --TODO: Dynamically generate "2".
            if v_gt_0_score_count = 2 and v_le_0_score_count = 0 then
                dbms_output.put_line('Expression: '||v_expression);
            end if;

        exception when others then
            dbms_output.put_line('Problem with: '||v_sqls(i));
        end;
    end loop;

    dbms_output.put_line('Queries executed: '||v_dynamic_query_counter);

end;
/