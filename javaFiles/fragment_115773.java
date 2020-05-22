select t.*,
       (select 0
        from t t2
        where left(t2.field, 8) = left(t.field, 8) and
              t2.field < t.field and
              right(t2.field, 7) + 0 = right(t.field, 7) + 0 - 1
       ) as NullIfStart
from t;