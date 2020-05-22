create table my_statistics (
  id int not null primary key auto_increment,
  version int not null,
  -- other columns with your data
);

create table stats_version (current_version int); -- holds just one row

create view stats as
select * 
from stats_version v
join my_statistics s on s.version = v.current_version);