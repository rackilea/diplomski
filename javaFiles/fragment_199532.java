listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            TextView songName = view.findViewById(R.id.song_name);
            TextView artistName = view.findViewById(R.id.artist);
            Intent intent = new Intent(MainActivity.this, nowPlaying.class);
            intent.putExtra("song_name", songName.getText().toString());
            intent.putExtra("artist_name", artistName.getText().toString());
            startActivity(intent);
        }
    });