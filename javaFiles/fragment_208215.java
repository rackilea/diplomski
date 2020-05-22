CREATE TABLE logs (
  id_log   SERIAL,
  username VARCHAR(255),
  time     TIMESTAMP
);

INSERT INTO logs (username) VALUES ('eggyal');