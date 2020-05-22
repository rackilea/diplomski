import com.aminography.glideapplication.glide.okhttp3.GlideApp;
import com.aminography.glideapplication.glide.okhttp3.JsonApiGlideUrl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);

        String sourceUrl = "https://www.myfitbytes.com/wp-json/wp/v2/media/2811";

        textView.setText("JsonApiGlideUrl:\n\n" + sourceUrl);

        final JsonApiGlideUrl url = new JsonApiGlideUrl(sourceUrl);
        GlideApp.with(MainActivity.this).load(url).into(imageView);
    }

}