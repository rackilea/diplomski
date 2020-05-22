select s.testval3,testval5
        from (select distinct testval3,testval5 
            from a_staging_table) s 
        where not exists
        (select 1
          from your_original_table
           where mycolumn1=s.testval3
             and mycolumn2=s.testval5);