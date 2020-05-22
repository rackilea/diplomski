lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View arg0,
                                int position, long id) {

            Log.i("Index", "..." + position);
            songAdapter.setSelectedIndex(position);
            Intent i = new Intent(getActivity().getApplicationContext(),Main.class);
            SongModel songModel = (SongModel) songAdapter.getItem(position);
            int indexOfSong = songAdapter.songsList.indexOf(songModel);

            // Sending songIndex to PlayerActivity
            i.putExtra("songIndex", indexOfSong);
            getActivity().setResult(100, i);
            startActivityForResult(i, 100);

            //putting song in recentSongList arraylist
            SongModel model = (SongModel) songAdapter.getItem(position);
            model.setSongTitle(songModel.getSongTitle());
            model.setSongPath(songModel.getSongPath());
            Constant.recentSongList.add(model);
            Log.i("recentSongList...","..."+Constant.recentSongList.size());
        }
    });