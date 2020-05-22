public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    btn1 = (Button) findViewById(R.id.button1);
    btn1.setOnClickListener( new OnClickListener() {
        public void onClick(View v) {
            new AlertDialog.Builder(this).setTitle("MessageDemo").setMessage(
                "This is an Alert Dialogue Toast").setNeutralButton(
                "Here, here!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {
                        Toast.makeText(HelloWorldActivity.this,
                            "<clink, clink>", Toast.LENGTH_SHORT).show();
                    }
            }).show();            
        }
    });

    btn2 = (Button) findViewById(R.id.button2);
    btn2.setOnClickListener( new OnClickListener() {
        public void onClick(View v) {
            // Do something different here.
        }
    });

    // The rest of onCreate
}