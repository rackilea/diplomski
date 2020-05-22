create type color as enum('white', 'blue', 'green');

with the_data(a_color) as (
    values ('white'::color), ('blue'), ('green')
)

select *
from the_data
where a_color = any(array['white', 'blue']::color[]);