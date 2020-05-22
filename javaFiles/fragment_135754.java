public void onCreate(Bundle savedInstanceState) {
   // other onCreate code
    btn1 = (Button) findViewById(R.id.button1);
    btn1.setOnClickListener( new OnClickListener() {
        public void onClick(View v) {
            showBtn1ClickedDialog();
        }
    });
   // other onCreate code
}

private void showBtn1ClickedDialog() {
    new AlertDialog.Builder(this).setTitle("MessageDemo").setMessage(
        "This is an Alert Dialogue Toast").setNeutralButton(
        "Here, here!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dlg, int sumthin) {
                Toast.makeText(HelloWorldActivity.this,"<clink, clink>", Toast.LENGTH_SHORT).show();
            }
    }).show();            
}