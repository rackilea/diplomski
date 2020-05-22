public Song searchById (String id){
        Song selectedSong = null;
        for(int index=0; index<allSongs.length; index++){
            selectedSong = allSongs[index];
            if(selectedSong.getId().equals(id)){
            return selectedSong;
        }
    }
    return selectedSong;
}