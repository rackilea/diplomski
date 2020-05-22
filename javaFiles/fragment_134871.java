public class Playlist { 

private Vector<Song> songList;

public void setSong(Song song) { 
    if (song != null) {
             songList.add(song);
        }
   }
public Song getSong(int nb) {
    if (nb > 0 && nb < songList.size()) //We don't want to check the song #-1 or a song that would be out of bonds
         return songList.elementAT(nb);
}
 }