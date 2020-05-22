create table contact (
  id MEDIUMINT not null AUTO_INCREMENT,
  firstName VARCHAR(64),
  lastName varchar(128),
  city varchar(64),
  state char(2),
  email VARCHAR(64),
  PRIMARY KEY (id)
);