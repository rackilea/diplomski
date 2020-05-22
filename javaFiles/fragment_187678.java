select
    foods,
    first_count,
    second_count
from
    (select first_food as food from menus
    union select second_food from menus) as f
    left join (
        select first_food, count(*) as first_count from menus
        group by first_food
        ) as ff on ff.first_food=f.food
    left join (
        select second_food, count(*) as second_count from menus
        group by second_food
        ) as sf on sf.second_food=f.food
 ;