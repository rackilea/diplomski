drop procedure if exists get_golfer_rank;

delimiter #

create procedure get_golfer_rank
(
p_golferID int unsigned
)
proc_main:begin

set @rank = 0;

select 
...
where golferID = p_golferID;

end proc_main #

delimiter ;


call get_golfer_rank(18);