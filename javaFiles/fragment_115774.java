select t.*
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
         where right(tnis.field, 7) = right(t.field, 7) and
               tnis.field <= t.field
        ) grp
from t;