public boolean isRepeatingPlaylist() 
{
    Set<Song> songs = new HashSet<Song>();
    songs.add(this);
    Song current = this.getNextSong();
    //if you did not implment a getter for the nextSong property I think you should
    while (current.getNextSong() != null && !songs.contains(current.getNextsong())) {

        songs.add(current);
        current = current.getNextSong();
    }

    return songs.contains(current.getNextsong()); 
}