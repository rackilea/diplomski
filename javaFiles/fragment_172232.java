select t.SoldSeats, z.Capacity
from (select count(*) as SoldSeats,
      from Ticket t
      where t.vertoning.zaal.cinemacomplex.id = :id
     ) t
     (select sum(z.capaciteit)  as Capacity
      from Zaal z
     ) z;