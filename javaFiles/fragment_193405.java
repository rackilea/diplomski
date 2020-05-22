public class MainActivity extends Activity {
  LocationManager manager; 
  AlertDialog.Builder box;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    box = new AlertDialog.Builder(this);
    manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
    Status();
  }
}