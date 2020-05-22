public static void main(String[] args) throws NegativeDurationException {
    MusicAlbum album = new MusicAlbum("title", "author", "03/10/2003", PhysicalMedia.CD);
    MusicTrack track1 = new MusicTrack("title_1", "author_1", 30);
    MusicTrack track2 = new MusicTrack("title_2", "author_2", 40);
    MusicTrack track3 = new MusicTrack("title_3", "author_3", 10);
    MusicTrack track4 = new MusicTrack("title_4", "author_4", 20);
    album.addMusicTracks(track1, track2, track3, track4);
    Iterator<MusicTrack> iter = album.iterator();
    while (iter.hasNext()) {
        System.out.println(iter.next());
    }
    System.out.println("====================================================================");
    album.getTracks().forEach(System.out::println);
}