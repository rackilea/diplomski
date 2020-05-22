CREATE TABLE tagged_songs (
  tag varchar,
  song_id uuid,
  song_title varchar,
  ... anything else you might need with your songs here ...
  PRIMARY KEY ((tag), song_id)
);