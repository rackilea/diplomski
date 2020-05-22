public static List<Genre> MakeArrayAsList() {
    Genre[] genres = new Genre[20];
    for(int i=0;i<20;i++) {
        //add 20 array items like this
        genres[i] = newGenre("Rock",makeRockArtists(),R.drawable.ic_music_note_black_24dp);
    }
    //make Array.asList() using those 20 items to return
    // return Arrays.asList  
    return Arrays.asList(genres);
}