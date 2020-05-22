import java.util.*;

/**
 *
 * @author Sedrick
 */
public class AlbumTest {

    static final String[] trackTitles = {"Ambitionz Az a Ridah", "All Bout U", "Skandalouz", "Got My Mind Made Up", "How Do U Want It", "2 of Amerikaz Most Wanted", "No More Pain", "Heartz of Men", "Life Goes On", "Only God Can Judge Me", "Tradin' War Stories", "California Love(Remix)", "I Ain't Mad at Cha", "What'z Ya Phone #"};

    static final String[] trackLength = {"4:39", "4:37", "4:09", "5:14", "4:47", "4:07", "6:14", "4:43", "5:02", "4:57", "5:29", "6:25", "4:53", "5:10"};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Add album info
        AlbumInfo allEyesOnMeDiscOne = new AlbumInfo();
        allEyesOnMeDiscOne.setAlbumName("All Eyes On Me");
        allEyesOnMeDiscOne.setArtist("Tupac");
        for (int i = 0; i < trackTitles.length; i++) {
            allEyesOnMeDiscOne.addTrackTitle(trackTitles[i]);
        }

        for (String entry : trackLength) {
            allEyesOnMeDiscOne.addTrackLength(entry);
        }

        //Print album info
        System.out.println("Album Name: " + allEyesOnMeDiscOne.getAlbumName());
        System.out.println("Album Artist: " + allEyesOnMeDiscOne.getArtist());
        List albumTitles = allEyesOnMeDiscOne.getTracksTitle();
        List albumTitlesLength = allEyesOnMeDiscOne.getTracksLength();

        for (int i = 0; i < albumTitles.size(); i++) {
            System.out.println("Title: " + albumTitles.get(i) + "  Length: " + albumTitlesLength.get(i));
        }

    }
}