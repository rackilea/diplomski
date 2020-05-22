DataSongs songData = new DataSongs();
        for (int i = 0; i < songs.length(); i++) {
            JSONObject song = songs.getJSONObject(i);
            songData.songName = song.getString("song");
            songData.songGenreID = song.getString("GenreID");
            songData.songUserID = song.getString("UserID");
            data.add(songData);
            Log.e("songo", "SongName: " + data.get(i).songName);
        }