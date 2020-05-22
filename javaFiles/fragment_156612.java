delimiter ;

drop procedure if exists getCustomerById;

delimiter #

create procedure getCustomerById
(
 in p_id int unsigned
)
begin
  select c.* from customer c where c.id = p_id;
end #

delimiter ;