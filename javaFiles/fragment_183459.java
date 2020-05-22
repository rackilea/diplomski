create table usertable (
    username varchar(128) NOT NULL CONSTRAINT USER_PK PRIMARY KEY ,
    password varchar(128) NOT NULL,
    email varchar(128) NOT NULL,
    firstname varchar(128) NOT NULL,
    lastname varchar(128) NOT NULL
);

create table grouptable(
    username varchar(128) NOT NULL,
    groupid  varchar(128) NOT NULL,
    CONSTRAINT GROUP_PK PRIMARY KEY(username, groupid),
    CONSTRAINT USER_FK FOREIGN KEY(username) REFERENCES usertable(username)
        ON DELETE CASCADE ON UPDATE RESTRICT
);

insert into usertable(username,password,firstname,lastname) 
    values ('admin', '21232f297a57a5a743894a0e4a801fc3','','');
insert into grouptable(username,groupid) values ('admin', 'USER');
insert into grouptable(username,groupid) values ('admin', 'ADMIN');