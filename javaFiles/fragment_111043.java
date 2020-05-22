when we are using Oracle database then the table structure is like below
CREATE TABLE users (username VARCHAR(50) PRIMARY KEY, password VARCHAR(50) NOT NULL, enabled VARCHAR(50) NOT NULL)
  create table authorities (
      username varchar(50) not null,
      authority varchar(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      create unique index ix_auth_username on authorities (username,authority);

the problem was in table structure.