public class ContactInfo extends AppCompatActivity {

TextView ContactInfoFamily_Name;
TextView ContactInfoFirst_Name;
TextView ContactInfoHouse_Number_ ;
TextView ContactInfoStreet_Name;
TextView ContactInfoTown_;
TextView ContactInfoCounty_;
TextView ContactInfoPost_Code;
TextView ContactInfoPhone_Number;
DatabaseHandler dbHandler = new DatabaseHandler(getApplicationContext());


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contact_info);

    ContactInfoFamily_Name = (TextView) findViewById(R.id.ContactInfoFamilyName);
    ContactInfoFirst_Name = (TextView) findViewById(R.id.ContactInfoFirstName);
    ContactInfoHouse_Number_ = (TextView) findViewById(R.id.ContactInfoHouseNumber);
    ContactInfoStreet_Name = (TextView) findViewById(R.id.ContactInfoStreetName);
    ContactInfoTown_ = (TextView) findViewById(R.id.ContactInfoTown);
    ContactInfoCounty_ = (TextView) findViewById(R.id.ContactInfoCounty);
    ContactInfoPost_Code = (TextView) findViewById(R.id.ContactInfoPostCode);
    ContactInfoPhone_Number = (TextView) findViewById(R.id.ContactInfoPhone);


    Intent intent = getIntent();
    Bundle cBundle = intent.getExtras();

    Contact ContactInfo = (Contact) cBundle.getSerializable("ParseContactID");

    ContactInfoFamily_Name.setText(ContactInfo.getID());
    ContactInfoFirst_Name.setText(getIntent().getExtras().getString("FirstNameKey"));
    ContactInfoHouse_Number_.setText(getIntent().getExtras().getString("HouseNumberKey"));
    ContactInfoStreet_Name.setText(getIntent().getExtras().getString("StreetNameKey"));
    ContactInfoTown_.setText(getIntent().getExtras().getString("TownKey"));
    ContactInfoCounty_.setText(getIntent().getExtras().getString("CountyKey"));
    ContactInfoPost_Code.setText(getIntent().getExtras().getString("TownKey"));
    ContactInfoPhone_Number.setText(getIntent().getExtras().getString("PhoneNumberKey"));


}
}