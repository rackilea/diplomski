insert into bigtable ( . . . )
    select . . . 
    from smalltable
    where not exists (select 1
                      from smalltable st join
                           bigtable bt
                           on st.unique_code_string = bt.unique_code_string
                      );