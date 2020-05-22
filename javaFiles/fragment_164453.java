//EntryPoint
private void mySharer() {
    ArrayList<Uri> streamUris = new ArrayList<Uri>();
    for (int i = 0; i < 10; i++) {
        File tmpFile = new File(getContext().getCacheDir(), "tmp" + i + ".jpg");
        Uri tmp = FileProvider.getUriForFile("com.test.myapp.fileprovider", tmpFile);
        streamUris.add(tmp);
    }
}

//Share Intent creator
public final void shareUris(ArrayList<Uri> streamUris) {
    if (!streamUris.isEmpty()) {
        Intent shareIntent = new Intent();
        shareIntent.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, getPackageName());
        shareIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, getComponentName());
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        shareIntent.setType("image/jpeg");

        if (streamUris.size() == 1) {
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM, streamUris.get(0));
        } else {
            shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
            shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, streamUris);
        }

        //For multiple images copy all images in the baseDir and use startActivityForResult
        startActivityForResult(Intent.createChooser(shareIntent, getString(R.string.share_image)), 500);
    }
}

//onResult you can delete all temp images/files with specified extensions
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch (requestCode) {
        case 500:
            getContentResolver().delete(FileProvider.getUriForFile(getPackageName() + ".fileprovider", null), FileProvider.WHERE_EXTENSION, new String[]{"jpg"});
            break;
        default:
            break;
    }
}

/**
 * This class extends the ContentProvider
 */
abstract class AbstractFileProvider extends ContentProvider {

    private final static String OPENABLE_PROJECTION_DATA = "_data";
    private final static String[] OPENABLE_PROJECTION = { OpenableColumns.DISPLAY_NAME, OpenableColumns.SIZE, OPENABLE_PROJECTION_DATA };

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (projection == null) {
            projection = OPENABLE_PROJECTION;
        }

        final MatrixCursor cursor = new MatrixCursor(projection, 1);
        MatrixCursor.RowBuilder b = cursor.newRow();

        for (String col : projection) {
            if (OpenableColumns.DISPLAY_NAME.equals(col)) {
                b.add(getFileName(uri));
            } else if (OpenableColumns.SIZE.equals(col)) {
                b.add(getDataLength(uri));
            } else if (OPENABLE_PROJECTION_DATA.equals(col)) {
                b.add(getFileName(uri));
            } else {
                b.add(null);
            }
        }

        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return URLConnection.guessContentTypeFromName(uri.toString());
    }

    protected String getFileName(Uri uri) {
        return uri.getLastPathSegment();
    }

    protected long getDataLength(Uri uri) {
        return AssetFileDescriptor.UNKNOWN_LENGTH;
    }

    @Override
    public Uri insert(Uri uri, ContentValues initialValues) {
        throw new RuntimeException("Operation not supported");
    }

    @Override
    public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
        throw new RuntimeException("Operation not supported");
    }

    @Override
    public int delete(Uri uri, String where, String[] whereArgs) {
        throw new RuntimeException("Operation not supported");
    }
}

/**
 * This class extends the AbstractFileProvider
 */
public class FileProvider extends AbstractFileProvider {

    public static final String CONTENT_URI = "content://";
    private File baseDir;

    @Override
    public boolean onCreate() {
        baseDir = getContext().getCacheDir();

        if (baseDir != null && baseDir.exists()) {
            return true;
        }

        Log.e("FileProvider", "Can't access cache directory");
        return false;
    }

    @Override
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        File f = new File(baseDir, uri.getPath());

        if (f.exists()) {
            return ParcelFileDescriptor.open(f, ParcelFileDescriptor.MODE_READ_ONLY);
        }

        throw new FileNotFoundException(uri.getPath());
    }

    @Override
    protected long getDataLength(Uri uri) {
        File f = new File(baseDir, uri.getPath());

        return f.length();
    }

    public static Uri getUriForFile(String authority, File file) {
        return Uri.parse(CONTENT_URI + authority + "/" + file.getName());
    }
}