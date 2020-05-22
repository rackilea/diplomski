private void changeSelectedSong(int index){
    songAdapter.notifyItemChanged(songAdapter.getSelectedPosition());
    currentIndex = index;
    songAdapter.setSelectedPosition(currentIndex);
    songAdapter.notifyItemChanged(currentIndex);

}


mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {



            if(currentIndex + 1 < SongList.size()){
                SongInfoModel next = SongList.get(currentIndex + 1);
                changeSelectedSong(currentIndex+1);
                prepareSong(next);
                mainActivity.setsongText(next);
            }else{
                SongInfoModel next = SongList.get(0);
                changeSelectedSong(0);
                prepareSong(next);
                mainActivity.setsongText(next);
            }



        }
    });