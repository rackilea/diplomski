select *
from some_table
where (
    name is not null
    and
    condition = 'T'
};