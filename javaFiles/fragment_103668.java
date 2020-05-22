...

private void prepareDefaultContent() {
        ArrayList<Song> songs = new ArrayList<>();
        //Resources r = recyclerView.getContext().getResources();

        String[] songTitle = getResources().getStringArray(R.array.songsTitles);
        String[] albumTitle = getResources().getStringArray(R.array.albumTitle);
        String[] songLength = getResources().getStringArray(R.array.songsLength);
        String[] artistName = getResources().getStringArray(R.array.artistName);

        TypedArray typedArray = getResources().obtainTypedArray(R.array.songsCoverArt);

        for (int i = 0; i < songTitle.length; i++) {

            int coverArtResourceId = typedArray.getResourceId(i, 0);

            Log.d(TAG, "Adding = " + songTitle[i] + " " + albumTitle[i] + " " + songLength[i] + " " + artistName[i] + " " + coverArtResourceId);

            songs.add(new Song(songTitle[i], albumTitle[i], songLength[i], artistName[i], coverArtResourceId));

        }

        typedArray.recycle(); // Important

        songAdapter.addItems(songs);
        recyclerView.setAdapter(songAdapter);

    }
...