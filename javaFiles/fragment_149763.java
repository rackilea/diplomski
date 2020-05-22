public final class MainActivity extends Activity {

    public MainActivity() {}

    private Connection connection;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (connection == null || connection.getStatus() != AsyncTask.Status.RUNNING) {
            connection = new Connection(imageView);
            connection.execute();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (connection != null && connection.getStatus() == AsyncTask.Status.RUNNING) {
            connection.cancel(true);
        }
    }

}