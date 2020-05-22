/* ------------- using sequence ----------- */
create sequence organisation_seq as bigint 
  start with 1 increment by 1;
create table organisation
(
  id bigint not null default next value for organisation_seq,
  customer_number varchar(50) unique
);

insert into organisation values
 (next value for organisation_seq, 'a')
,(200, 'b')
,(next value for organisation_seq, 'c');

select * from organisation;