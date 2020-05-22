insert into test(id,name,address) values(5,'name','address');
          --where 5 is your new PK.

    --Updating the child table
    update practice set p_id=5 where p_id=1 
          --where 1 is your old id in Test.

    --delete the record
    delete from test where id=1