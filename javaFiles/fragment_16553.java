import java.util.Random;

public class MainActivity extends DroidGap {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Random generator = new Random();
        int r = generator.nextInt();
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html?" + r);
    }
}