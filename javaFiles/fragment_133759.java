select t1.`id`, t1.`emailAddress`,
group_concat(t2.`uuid`)
from `users` t1
join `devices` t2
on t1.`id` = t2.`user_id`
group by t1.`id`, t1.`emailAddress`;