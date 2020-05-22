select  p.what,sum(p.popularity) 
from popularity p,tagged u
where u.who='USER'
and u.tag=p.tag
group by p.what 
order by 2 desc;
IMAGE1  10
IMAGEA  4
IMAGEX  4
IMAGEZ  4
IMAGEY  4
IMAGEF  3
IMAGED  3
IMAGEE  3
IMAGEC  3
IMAGEB  3
IMAGEG  3