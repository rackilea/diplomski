select min(field),
       (case when max(field <> min(field) then max(field) end)
from (select t.*
             (select sum(NullIfStart is null)
              from (select t1.*,
                           (select 0
                            from t t2
                            where left(t2.field, 8) = left(t1.field, 8) and
                                  t2.field < t1.field and
                                  right(t2.field, 7) + 0 = right(t1.field, 7) + 0 - 1
                           ) as NullIfStart
                     from t t1
                    ) tnis
               where left(tnis.field, 8) = left(t.field, 8) and
                     tnis.field <= t.field
              ) grp
      from t
     ) s
group by left(s.field, 8), grp;