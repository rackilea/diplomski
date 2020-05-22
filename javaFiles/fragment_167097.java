public Song implements Comparable<Song> {
    private String title;
    private String artist;
    private String album;

    public Song(String title, String artist, String album) {
       ...
    }

    public int compareTo(Song s) {
        // sorting logic
    }

    ... // getters, setters, equals & hashCode
}