import java.util.*;

/**
 *
 * @author Sedrick
 */
public class AlbumInfo {

    private String albumName;
    private String artist;
    private List<String> tracksTitle;
    private List<String> tracksLength;

    public AlbumInfo()
    {
        albumName = "Add Album Name";
        artist = "Add Artist Name";
        tracksTitle = new ArrayList();
        tracksLength = new ArrayList();
    }

    /**
     * @return the albumName
     */
    public String getAlbumName()
    {
        return albumName;
    }

    /**
     * @param albumName the albumName to set
     */
    public void setAlbumName(String albumName)
    {
        this.albumName = albumName;
    }

    /**
     * @return the artist
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    /**
     * @return the tracksTitle
     */
    public List<String> getTracksTitle()
    {
        return tracksTitle;
    }

    /**
     * @param tracksTitle the tracksTitle to set
     */
    public void addTrackTitle(String trackTitle)
    {
        this.tracksTitle.add(trackTitle);
    }

    /**
     * @return the tracksLength
     */
    public List<String> getTracksLength()
    {
        return tracksLength;
    }

    /**
     * @param tracksLength the tracksLength to set
     */
    public void addTrackLength(String trackLength)
    {
        this.tracksLength.add(trackLength);
    }

}