public class PlaylistTest extends FunctionalTest {

    @Test
    @Transactional
    public void insertIntoPlaylist() {
        Playlist playlist = new Playlist();
        playlist.setName("new_playlist_again");

        EntityManager em = JPA.em();
        em.persist(playlist);
    }
}