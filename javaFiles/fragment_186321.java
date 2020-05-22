/* ------------- using identity ----------- */
create table organisation_identity
(
  id bigint not null identity (1,1),
  customer_number varchar(50) unique
);

insert into organisation_identity values
('a');

/* ------------- identity_insert on ----------- */
set identity_insert organisation_identity on;
insert into organisation_identity (id, customer_number) values
(200, 'b');
set identity_insert organisation_identity off;
/* ------------- identity_insert off ----------- */

insert into organisation_identity values
('c');

select * from organisation_identity;