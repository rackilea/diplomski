create table a (
    id number primary key, org_id number, date_period date, cola varchar2(5),
    constraint uq_org_id_period unique (org_id, date_period) );
insert into a values (1, 101, date '2018-05-25', 'DEL');
insert into a values (2, 101, date '2018-05-26', 'PQR');
insert into a values (3, 102, date '2018-06-17', 'CBA');

create table b (
    id number primary key, org_id number, date_period date, colb varchar2(5),
    constraint fk_org_id_period 
        foreign key (org_id, date_period) 
        references a(org_id, date_period) on delete cascade);
insert into b values (1, 101, date '2018-05-26', 'AAXXX');
insert into b values (2, 102, date '2018-06-17', 'PCCQR');
insert into b values (3, 101, date '2018-05-25', 'DEL1');
insert into b values (4, 101, date '2018-05-25', 'DEL2');
insert into b values (5, 102, date '2018-06-17', 'XYZYX');