public class MainActivity extends AppCompatActivity {

    Cursor mAllContacts;
    Cursor mAllCompanies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase mDB = new DBHelper(this).getWritableDatabase();

        CompanyDB.addCompany(mDB,"mycompany");
        ContactDB.addContact(mDB,"Fred","Fred@email.com");
        ContactDB.addContact(mDB,"Bert","bertbloggins@bloggings.moc");

        mAllCompanies = CompanyDB.getAllCompanies(mDB);
        while (mAllCompanies.moveToNext()) {
            Log.d("COMPANY",
                    "Company Name = " +
                            mAllCompanies.getString(
                                    mAllCompanies.getColumnIndex(
                                            CompanyDB.COL_NAME
                                    )
                            )
            );
        }
        Cursor mAllContacts = ContactDB.getAllContacts(mDB);
        while (mAllContacts.moveToNext()) {
            Log.d("CONTACT",
                    "Contact Name = " +
                    mAllContacts.getString(
                            mAllContacts.getColumnIndex(
                                    ContactDB.COL_NAME
                            )
                    ) +
                    " Email = " +
                            mAllContacts.getString(
                                    mAllContacts.getColumnIndex(
                                            ContactDB.COL_EMAIL
                                    )
                            )
            );
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAllCompanies.close();
        mAllContacts.close();

    }
}