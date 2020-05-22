private void alertView( String message ) {
    //create a dialog component
    final Dialog dialog = new Dialog(this);

    //tell the dialog to use the dialog.xml as its layout description
    dialog.setContentView(R.layout.dialog);
    dialog.setTitle("your title");

    TextView txt = (TextView) dialog.findViewById(R.id.txt);
    txt.setText(message);
    Button dialogButton = (Button)dialog.findViewById(R.id.dialogButton);
    dialogButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            mUartCom.write("D"); //change this 
        }
    });

    dialog.show();

}