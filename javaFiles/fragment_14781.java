public class YourActivity extends Activity {

    private double xCurrentPos, yCurrentPos;
    private ImageView test = (ImageView) findViewById(R.id.square);
    xCurrentPos = test.getLeft();
    yCurrentPos = test.getTop();

    ...
}