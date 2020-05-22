create table dog_owner 
(id number);
alter table dog_owner add  primary key (id);
insert into dog_owner values (1);

create table dog 
(id number,
dog_owner_id number not null); -- foreign key is not nullable ..
alter table dog add  primary key (id);
alter table dog add  foreign key (dog_owner_id) references dog_owner(id) 
ON DELETE SET NULL; -- but the contrains sets is to null...

insert into dog values (1,1);
commit;

delete from dog_owner where id = 1;

-- SQL-Fehler: ORA-01407: cannot update ("SCHEMA_NAME"."DOG"."DOG_OWNER_ID") to NULL 

alter table dog modify (dog_owner_id number  null);

delete from dog_owner where id = 1;

-- 1 rows deleted