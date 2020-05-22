create table testatble 
(
  d_id integer not null primary key,
  install_id integer not null,
  dashboard_name varchar(100)
  ... more columns ....
);

create sequence seq_testatble_d_id;