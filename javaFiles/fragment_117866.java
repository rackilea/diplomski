create table playlist
(
   id integer primary key not null, 
   ... other columns ...
);

create table playlistmovies
(
   id integer primary key not null,
   playlist_id integer not null,
   ... other columns
);

alter table playlistmovies
   add constraint fk_plm_playlist
   foreign key (playlist_id) references playlist(id)
   on delete cascade;