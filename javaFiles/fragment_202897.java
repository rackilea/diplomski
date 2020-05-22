public Button btn_send;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_email_receipt);

    btn_send = (Button)findViewById(R.id.send_receipt_button);
    btn_send.setOnClickListener(new View.OnClickListener(){
        @Override
        //Use the name of the function you assigned to the xml design of the   button
        public void onClick(View v){
            //Use the name of this class, and the name class where you want to be taken when the button is clicked.
            startActivity (new Intent(EmailReceiptActivity.this, SuccessActivity.class));
    }
}