SQL> select to_char(hire_date, 'yyyymm'), count(*)
  2  from employees
  3  where department_id in (10, 20)
  4  group by to_char(hire_date, 'yyyymm');

TO_CHA   COUNT(*)
------ ----------
200309          1
200508          1
200402          1

SQL>