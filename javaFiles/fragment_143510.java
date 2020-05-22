select
    *
from
    desarrollo.vw_product_computed a
join dbo.products b on b.product = a.a12
join dbo.products c on c.product = a.a10
where
    a.lvl = 7;