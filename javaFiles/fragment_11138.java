for (int i = 0; i < songs.length(); i++) {
            JSONObject song = songs.getJSONObject(i);

            DataSongs songData = new DataSongs();
            songData.songName = song.getString("song");
            songData.songGenreID = song.getString("GenreID");
            songData.songUserID = song.getString("UserID");
            data.add(songData);
            Log.e("songo", "SongName: " + data.get(i).songName);
        }