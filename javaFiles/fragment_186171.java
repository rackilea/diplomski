public class PlaylistBusinessTest {

     @Test
    public void testRemoveTracks() throws Exception {

    PlayList playList = new PlayList();
    playList.setId(222)
    playList.setName("fake name");


    PlaylistDaoBean playlistDaoBeanMock = mock(PlaylistDaoBean.class);
    when(playlistDaoBeanMock.getPlaylistByUUID(uuid)).thenReturn(playList);

    PlaylistBusinessBean playlistBusinessBean = new PlaylistBusinessBean(playlistDaoBeanMock);

    playlistBusinessBean.removeTracks(uuid, Arrays.asList(2, 3));


    }