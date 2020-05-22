----------------------
-- create t_user table
----------------------
CREATE TABLE t_user (
      id INT GENERATED ALWAYS AS IDENTITY CONSTRAINT pk_user PRIMARY KEY,
      name      VARCHAR(60) NOT NULL,
      birthday  DATE,
      email     VARCHAR(60),
      password  VARCHAR(100),
      role      VARCHAR(300),
      enabled   SMALLINT(6)
);