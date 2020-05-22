class Track implements Comparable<Track> {

    String title;
    String artist;
    String rating;
    String bpm;

    @Override
    public int compare(Track other) {
        return this.getArtist().compareTo(other.getArtist());
    }

    ...