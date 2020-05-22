EditText etText;
EditText returnAddress;
public void onCreate(Bundle savedInstanceState) {
    //....
    Button send = (Button) findViewById(R.id.emailSendButton);
    etText = (EditText) findViewById(R.id.etEmailText);
    returnAddress = (EditText) findViewById(R.id.etReturnAddress);
     send.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {

            String text = etText.getText().toString();
            String returnAddressText = returnAddress.getText().toString();

            emailText =
                "\n\nArea in the Guide: " + area
                + "\n\nSuggestion or Comment: " + text + 
                "\n\nReturn Address: "+ returnAddressText;

            Intent emailIntent = new Intent(
                    android.content.Intent.ACTION_SEND);

            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                    address);
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                    "Suggestions/Comments: Black Ops 2");
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                    emailText);
            emailIntent.setType("text/plain");

            startActivity(Intent.createChooser(emailIntent, "Send Mail"));
            finish();
        }

    });
    //...
}