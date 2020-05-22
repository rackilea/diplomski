This is how you do it..

SpotifyApi api = new SpotifyApi();
    api.setAccessToken(token);
    SpotifyService spotify = api.getService();
    spotify.getPlaylists("USERID", new Callback<Pager<Playlist>>() {
        @Override
            public void success(Pager<Playlist> playlistPager, Response response) {
                Log.d("TEST", "Got the playlists");
            List<Playlist> playlists = playlistPager.items;
                    for (Playlist p : playlists) {
                        Log.e("TEST", p.name + " - " + p.id);
            }
        }
            @Override
            public void failure(RetrofitError error) {
                Log.e("TEST", "Could not get playlists");
        }
    });
    Once you know the playlist ID, you can then fetch the tracks of the playlist with something like this :

    spotify.getPlaylistTracks("USERID","PLAYLISTID", new Callback<Pager<PlaylistTrack>>() {
        @Override
            public void success(Pager<PlaylistTrack> playlistTrackPager, Response response) {
            Log.e("TEST", "GOT the tracks in playlist");
            List<PlaylistTrack> items = playlistTrackPager.items;
            for( PlaylistTrack pt : items){
                Log.e("TEST", pt.track.name + " - " + pt.track.id);
            }
        }
        @Override
            public void failure(RetrofitError error) {
                Log.e("TEST", "Could not get playlist tracks");
            }
    });

coutesy lunai 
https://github.com/spotify/android-sdk/issues/79