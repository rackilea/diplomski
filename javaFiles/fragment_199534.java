listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, nowPlaying.class);
                intent.putExtra("song_name", songs.get(i).getSongName()); // Note: If the getters are not set to get the song name and artist name then they need to be set to use this approach
                intent.putExtra("artist_name", songs.get(i).getArtistName());
                startActivity(intent);
            }
        });