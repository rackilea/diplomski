public class Results extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Button sendEmail = (Button) findViewById(R.id.resultsEMAIL);
      sendEmail.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {

        Sender sender = new Sender();
        sender.sendEmail(Results.this);
    }
});