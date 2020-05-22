songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        songFragment = new SongFragment();
       // -----> HERE <-----
        songFragment.getSongData(song.getArtist(), song.getSongName(), song.getName(), song.getArtistImg());
       // -----> HERE <-----

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();


        fragmentTransaction.replace(R.id.fragment_container, songFragment).addToBackStack(null).commit();

    }
});