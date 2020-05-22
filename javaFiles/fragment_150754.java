create table demo (datecolumn varchar2(8));

insert all
    into demo (datecolumn) values ('20180101')
    into demo (datecolumn) values ('20180399')
    into demo (datecolumn) values ('20180299')
select * from dual;

with function to_date_safe(p_datestr varchar2) return date
     as
         invalid_day_for_month exception;
         pragma exception_init(invalid_day_for_month, -1847);
         l_result date;
     begin
         begin
             l_result := to_date(p_datestr,'YYYYMMDD');
         exception
             when invalid_day_for_month then
                 l_result := last_day(to_date(substr(p_datestr,1,6),'YYYYMM'));
         end;

         return l_result;
     end;
select datecolumn
     , to_date_safe(datecolumn) as converted_date
from   demo
/

DATECOLUMN CONVERTED_DATE
---------- -------------
20180101   01-JAN-2018
20180399   31-MAR-2018
20180299   28-FEB-2018

3 rows selected.