@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

            ----
            ----
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
    super.onActivityResult(requestCode, resultCode, intent);

    if (requestCode == 0) {
              if (resultCode == RESULT_OK) {
                 String contents = intent.getStringExtra("SCAN_RESULT");
                 String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                 // Handle successful scan
                 EditText passphrase = (EditText) findViewById(R.id.txtPassphrase);
                 passphrase.setText(contents);
              } else if (resultCode == RESULT_CANCELED) {
                 // Handle cancel
              }
           }

}