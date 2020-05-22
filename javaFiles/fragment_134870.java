public class Playlist { 
private Song firstSong;
private Song secondSong;
private Song thirdSong;

public void setSong(Song song) { 
    if (song != null) {
        if (this.firstSong == null) {
            this.firstSong = song;
            System.out.println("The song has been added to the playlist.");
        }

        else if (this.secondSong == null) {
            this.secondSong = song;
            System.out.println("The song has been added to the playlist.");
        }

        else if (this.thirdSong == null) {
            this.thirdSong = song;
            System.out.println("The song has been added to the playlist.");
        }
        else {
            System.out.println("This playlist is currently full with 3 songs. Please delete a song before attempting to add a new one.");
        }
    }
   }