public class MainActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button button = (Button) findViewById(R.id.button2);
    registerForContextMenu(button);
}

@Override
public void onCreateContextMenu(ContextMenu menu, View v,
        ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);
    getMenuInflater().inflate(R.menu.main, menu);
}

public void showPopup(View v) {
    PopupMenu popup = new PopupMenu(this, v);
    getMenuInflater().inflate(R.menu.main, popup.getMenu());
    popup.show();
    popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {

        @Override
        public boolean onMenuItemClick(MenuItem arg0) {
            Toast.makeText(MainActivity.this, "" + arg0, Toast.LENGTH_SHORT)
                    .show();
            return false;
        }
    });
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}