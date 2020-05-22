public class DropboxDownloadTask extends AsyncTask<String, Void, File> {

    public interface OnDropboxDownloadListener {
        void onSuccess(File dropboxFile);
    }

    private static final String APP_KEY = "my-app-key";
    private static final String APP_ACCESS = "my-access-key";
    private static final String TOKEN = "my-token";

    // TODO: See below
    // private final String appKey, appAccess, dropboxToken;

    private final Context context;
    private final AndroidAuthSession session;
    private final DropboxAPI<AndroidAuthSession> dropboxAPI;

    private OnDropboxDownloadListener listener;

    public DropboxDownloadTask(Context c) {
        this.context = c;

        // TODO: Move those strings to a string resource file
        /*
        appKey = c.getResources().getString(R.string.dropbox_app_key);
        appAccess = c.getResources().getString(R.string.dropbox_access_key);
        dropboxToken = c.getResources().getString(R.string.dropbox_token);
        */

        session = buildSession();
        dropboxAPI = new DropboxAPI<AndroidAuthSession>(session);
    }

    public void setOnDownloadListener(OnDropboxDownloadListener listener) {
        this.listener = listener;
    }

    private AndroidAuthSession buildSession() {
        AppKeyPair appKeyPair = new AppKeyPair(APP_KEY, APP_ACCESS);
        AndroidAuthSession session = new AndroidAuthSession(appKeyPair);
        session.setOAuth2AccessToken(TOKEN);
        return session;
    }

    @Override
    protected File doInBackground(String... params) {
        File file;
        if (params.length != 2) {
            throw new IllegalArgumentException("Must give Dropbox to and from paths!");
        }
        String downloadPathTo = params[0];
        String downloadPathFrom = params[1];

        file = new File(downloadPathTo + downloadPathFrom.substring(downloadPathFrom.lastIndexOf('.')));
        if (file.exists()) file.delete();

        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            dropboxAPI.getFile(downloadPathFrom, null, outputStream, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return file;
    }

    @Override
    protected void onPostExecute(File result) {
        if (this.listener != null) {
            this.listener.onSuccess(result);
        }
    }
}