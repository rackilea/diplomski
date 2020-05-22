select {u.pk}, {b.pk}, count(distinct({c.pk})) 
from {
   user as u 
   join cart as c on {c.user} = {u.pk} 
   join basestore as b on {b.pk} = {c.store}
} 
group by {u.pk}, {b.pk} 
having count(distinct({c.pk})) > 1