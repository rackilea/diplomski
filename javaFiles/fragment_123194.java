merge into table o
using (select :1, :2 ... ) n
   on ( o.date = n.date
       and o.hash = n.hash
       and o.app_id = n.app_id
           )
 when matched then
      update
         set ...
 when not matched then
      insert (...

commit;

delete from table
 where date < :1 
   and hash = :2

commit;