public class MainActivity extends AppCompatActivity {
...
    int ACTION_REQUEST_MULTIPLE_PERMISSION = 1;  // Any number

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...

        int pCheck = this.checkSelfPermission("Manifest.permission.ACCESS_FINE_LOCATION");
        pCheck += this.checkSelfPermission("Manifest.permission.ACCESS_COARSE_LOCATION");
        pCheck += this.checkSelfPermission("Manifest.permission.BLUETOOTH_ADMIN");
        pCheck += this.checkSelfPermission("Manifest.permission.BLUETOOTH");
        if (pCheck != 0) {
            this.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.BLUETOOTH_ADMIN, Manifest.permission.BLUETOOTH}, ACTION_REQUEST_MULTIPLE_PERMISSION);
        }
    }
}