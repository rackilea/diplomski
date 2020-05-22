CREATE TABLE users
(
  user_id serial PRIMARY KEY,
  email character varying(255) NOT NULL UNIQUE,
  passhash character varying(255) NOT NULL
);
CREATE TABLE users_groups
(
  users_groups_id serial PRIMARY KEY,
  user_email character varying(255) NOT NULL REFERENCES users(email),
  group_name character varying(20) NOT NULL REFERENCES groups(group_name)
);
CREATE TABLE groups
(
  group_name character varying(20) PRIMARY KEY
);