exec dbms_random.seed(47);

anonymous block completed

select dbms_random.value from dual;

     VALUE
----------
  .5976804 

select dbms_random.value from dual;

     VALUE
----------
.329618924 

-- reset
exec dbms_random.seed(47);

anonymous block completed

select dbms_random.value from dual;

     VALUE
----------
  .5976804 

select dbms_random.value from dual;

     VALUE
----------
.329618924