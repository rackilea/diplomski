private ImageView mImageView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        Intent i = getIntent();

        String title = i.getStringExtra("about");
        String url = i.getStringExtra("image"); //get the url String

        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(title);

        //I switched from ParseImageView to regular ImageView here
        mImageView = (ImageView) findViewById(R.id.image);

        new DownloadImageTask(url).execute();
    }

public class DownloadImageTask extends AsyncTask<Void, Void, Bitmap> {

    private String imageUrl;

    public DownloadImageTask(String url) {
        this.imageUrl = url;
    }

    @Override
    protected Bitmap doInBackground(Void... params) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            // Log exception
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        mImageView.setImageBitmap(result);
    }    
}