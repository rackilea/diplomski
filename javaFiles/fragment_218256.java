public class TestAppActivity extends Activity {

    private ImageView imageView;
    private int imageNumber = 1;
    private String plakatiUrl = "http://plakati.bg/";
    private Drawable image = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slides);

        image = LoadImageFromWeb(generateUrlString(plakatiUrl, imageNumber));
        imageView = new ImageView(getBaseContext());
        imageView = (ImageView) findViewById(R.id.imageView1);
        imageView.setImageDrawable(image);

        Button nextButton = (Button) findViewById(R.id.nextBtn);
        nextButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                imageNumber++;

                image = LoadImageFromWeb(generateUrlString(plakatiUrl, imageNumber));

                imageView.setImageDrawable(image);
            }
        });

    }

    private Drawable LoadImageFromWeb(String url) {
        Drawable d = null;

        InputStream is;
        try {
            is = (InputStream) new URL(url).getContent();
            d = Drawable.createFromStream(is, "src name");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return d;
    }

    private String generateUrlString(String str, int n) {

        return str + Integer.toString(n) + ".jpg";
    }
}