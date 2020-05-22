public class MainActivity extends Activity implements DropboxDownloadTask.OnDropboxDownloadListener {

    private DropboxDownloadTask dropboxDownloadTask;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // pass the context 
        dropboxDownloadTask = new DropboxDownloadTask(this);
        // pass the listener 
        dropboxDownloadTask.setOnDownloadListener(this);

        // TODO: Implement 
        downloadFromDropbox("to", "from");

    }

    private void downloadFromDropbox(String downloadPathTo, final String downloadPathFrom) {
        Toast.makeText(getApplicationContext(), "Downloading  Please wait ...", Toast.LENGTH_LONG).show();
        dropboxDownloadTask.execute(downloadPathFrom, downloadPathTo);
    }

    @Override
    public void onSuccess(File dropboxFile) {
        Toast.makeText(getApplicationContext(), "File successfully downloaded.", Toast.LENGTH_SHORT).show();

        Intent promptInstall = new Intent(Intent.ACTION_VIEW)
                .setDataAndType(Uri.fromFile(dropboxFile), "application/vnd.android.package-archive");
        promptInstall.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(promptInstall);
    }
}