@RunWith(GuiceRobolectricJUnitRunner.class)
public class PhotoDatabaseTest {

    @Inject
    private Context context;

    @Inject
    private SharedPreferences sharedPreferences;

    @Test
    public void dataInsertBaseTest() throws SQLException {
        PhotosUploadDataSource photosUploadDataSource = new PhotosUploadDataSource(context);
        photosUploadDataSource.deleteAll();

        MediaItem mediaItem = new MediaItem();
        mediaItem.setLocation("/test/");
        mediaItem.setName("photo.jpg");
        mediaItem.setSize(5496849);
        mediaItem.setStatus(MediaItem.STATUS_PENDING);
        mediaItem.setType("images/jpg");
        MediaItem resultItem = photosUploadDataSource.createMediaItem(mediaItem);
        assertNotNull(resultItem);
        Utils.displayObject(resultItem);
    }
  }