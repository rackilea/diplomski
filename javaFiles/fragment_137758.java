import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);

        LongShadowTextView longShadow = new LongShadowTextView(this);
        longShadow.setText("Hello World");
        setContentView(longShadow);
    }
}