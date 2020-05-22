import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements SlideToUnlock.OnSlideToUnlockEventListener {

    private SlideToUnlock slideToUnlockView, slideToUnlockView2;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slideToUnlockView = (SlideToUnlock) findViewById(R.id.slideToUnlock);
        slideToUnlockView.setExternalListener(this);

        slideToUnlockView2 = (SlideToUnlock) findViewById(R.id.slideToUnlock2);
        slideToUnlockView2.setExternalListener(this);
    }

    private void showToast(String text) {
        if (toast != null) {
            toast.cancel();
        }

        toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onSlideToUnlockCanceled() {
        showToast("Canceled");
    }

    @Override
    public void onSlideToUnlockDone() {
        showToast("Unlocked");
    }
}