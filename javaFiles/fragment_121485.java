create table roles
(
  id               serial                not null
    constraint roles_pkey
    primary key,
  version          bigint default 0
);

create table users
(
  id               serial                not null
    constraint users_pkey
    primary key,
  version          bigint  default 0
);

create table users_roles
(
  user_id integer not null
    constraint fk_users
    references users,
  role_id integer not null
    constraint fk_roles
    references roles,
  constraint users_roles_pkey
  primary key (user_id, role_id)
);