create view vw_product_computed as
select
    a.lvl,
    a.Product,
    left(a.product, 12) as a12, -- your first lelvel down (artificial key) 
    left(a.product, 10) as a10  -- your seccond level down (artificial key) 
from
    products a;