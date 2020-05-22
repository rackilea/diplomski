CREATE TABLE users (
  user_id SERIAL,
  -- ...
);
-- ...
CREATE TABLE user_updates_audit (
  audit_id SERIAL,
  user_id INT NOT NULL,
  audit_timestamp TIMESTAMP NOT NULL default now(),
  -- just free form text describing applied update (maybe old value, new value, etc)
  audit_text VARCHAR(1024) NOT NULL
);

ALTER TABLE user_updates_audit ADD CONSTRAINT user_updates_audit_pk PRIMARY KEY (audit_id);
ALTER TABLE user_updates_audit ADD CONSTRAINT user_updates_audit_user_id_fk FOREIGN KEY (user_id) REFERENCES users;