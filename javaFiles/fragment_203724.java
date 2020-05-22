public Song searchById (String id){
        //we are returning the song selected by the index of its Arrays
        Song selectedSong = allSongs[Integer.parseInt(id)];

    return selectedSong;
}