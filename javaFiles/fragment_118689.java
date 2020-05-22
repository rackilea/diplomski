select c1 
from Class1 c1 
join c1.class2 c2 
where c2.id in (1,2,3)
group by c1
having count(c1)=3 ;