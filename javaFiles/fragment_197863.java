public class Track {
    private final String name;
    private final MediaPlayer music;
    public Track (String name, MediaPlayer music) {
        this.name = name;
        this.music = music;
    }
    // getters omitted
}

public class CD {
    private final String name;
    private final BitMap image; 
    private final List<Track> tracks = new ArrayList<Track>();
    public CD (String name, BitMap image) {
        this.name = name;
        this.image = image;
    }
    public List<Track> getTracks() {
        return tracks;
    } 
    // other getters omitted
}