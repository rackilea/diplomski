import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class launcher extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        showMyDialog();
    }

    public void showMyDialog() {    
      CustomDialogFragment newFragment = new CustomDialogFragment();
      newFragment.show(getSupportFragmentManager(), "custom");
    }
}