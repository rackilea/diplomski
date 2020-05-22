import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    private Camera cam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cam = Camera.open();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void toggleButtonClick(View view){

        Parameters p;

        if(getToggleButton().isChecked()){
            p = cam.getParameters();
            p.setFlashMode(Parameters.FLASH_MODE_TORCH);
            cam.setParameters(p);
            cam.startPreview();
        }
        else{
            p = cam.getParameters();
            p.setFlashMode(Parameters.FLASH_MODE_OFF);
            cam.setParameters(p);
            cam.stopPreview();
        }
    }

    public ToggleButton getToggleButton(){
        return (ToggleButton) findViewById(R.id.toggleButton1);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        cam.release();
    }
}