public class gender_details extends AppCompatActivity {

    private TextView tutor_email,tutor_mobile;
    private ImageView img;
     String tutor_email_txt;
        String tutor_mobile_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_details); // get the reference of Toolbar
        toolbar.setTitle(getIntent().getStringExtra(KEY_NAME));
        toolbar.setLogo(R.drawable.ic_person_black_24dp);
        setSupportActionBar(toolbar);




       


        tutor_email_txt = intent.getStringExtra(EMAIL);
        tutor_mobilee_txt = intent.getStringExtra(MOBILE);
        // Setting values

        TextView Email_Txt = (TextView) findViewById(R.id.tutor_email);
        Email_Txt.setText(tutor_email_txt);

         TextView Contact_Txt = (TextView) findViewById(R.id.tutor_contact);
        Contact_Txt.setText(String tutor_mobile_txt);
    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.toolbar_menu, menu);
            return true;
        }
// Activity's overrided method used to perform click events on menu items
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
//noinspection SimplifiableIfStatement
// Display menu item's title by using a Toast.
            if (id == R.id.action_call) {


                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+tutor_mobile_txt));
                startActivity(intent);


                return true;
            } else if (id == R.id.action_email) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, tutor_email_txt);
                intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                startActivity(Intent.createChooser(intent, ""));

                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(gender_details.this, MainActivity.class);
        startActivity(intent);
    }
}