public class PlayActivity {
        List<Track> tracks = new ArrayList<Track>();

        public void onCreate() {
            tracks.add(new Track("Artist Name", "Track Name", R.drawable.tabtemplate, R.drawable.testcover));
            tracks.add(
                    new Track("Pink Floyd", "Comfortably Numb Solo 1", R.drawable.CNS1Tab, R.drawable.pink_floyd_the_wall));
        }

        public List<Track> getAllTracks() {
            return Collections.unmodifiableList(tracks);
        }

        public Track getTrack(int index) {
            return tracks.get(index);

        }
    }