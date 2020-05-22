create table OkTable (
   id int not null auto_increment
   , primary key (id)
);

create table MisunderstoodTable(
   id int not null auto_increment
   oktable int not null
   , primary key (id)
   , foreign key ok (oktable) references oktable (id)
);