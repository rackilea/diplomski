Begin
for x in (
    select s.testval3,testval5
    from (select distinct testval3,testval5 
        from a_staging_table) s 
    where not exists
    (select 1
      from your_original_table
       where mycolumn1=s.testval3
         and mycolumn2=s.testval5)
    ) loop

    DBMS_OUTPUT.put_line('testval3: '||x.testval3 || '      ------     '||'testval5: '||x.testval5);
    --write all these values into another file saying that these are not matching values, using UTL_FILE.

--Then finally truncate the table "a_staging_table"
--so that this data will not available next time, and next time again process will run with different file
end loop;