create table users (
id                            bigint auto_increment not null,
firstname                     varchar(45),
lastname                      varchar(45),
birthday                      datetime,
email                         varchar(60),
password                      varchar(32),
author                        tinyint(1) default 0,
points                        integer,
locked                        tinyint(1) default 0,
last_online                   datetime,
date_created                  datetime not null,
date_updated                  datetime not null,
constraint uq_users_email unique (email),
constraint pk_users primary key (id)
);