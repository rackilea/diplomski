public class Registrace extends AppCompatActivity implements View.OnClickListener {
    private static final Pattern PASSWORD_PATTERN =
        Pattern.compile("^" + "(?=.*[0-9])" +
                "(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\s+$)" + ".{6,}" + "$");

    private EditText editPrijmeni;
    private EditText editJmeno; 
    private EditText editEmail;
    private EditText editPwd;
    private EditText editPwd2;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_registrace);

        // Shouldn't you use a button instead of a text view?
        // It seems you want a "Login" button to go to a LoginActivity
        final TextView login = (TextView) findViewById(R.id.lnkLogin);
        login.setMovementMethod(LinkMovementMethod.getInstance());
        login.setOnClickListener(this);

        // You could use https://jakewharton.github.io/butterknife which simplifies this boilerplate code a lot 
        editJmeno = (EditText) findViewById(R.id.txtJmeno);
        editPrijmeni = (EditText) findViewById(R.id.txtPrijmeni);
        editEmail = (EditText) findViewById(R.id.txtEmail);
        editPwd = (EditText) findViewById(R.id.txtPassword);
        editPwd2 = (EditText) findViewById(R.id.txtPassword2);
        btn = (Button) findViewById(R.id.btnRegistrace);
        btn.setOnClickListener(this);
    }

    public boolean validujPrijmeni() {
        // if 'Mess' was for a validation message don't set it in the validation method.
        // define a string in your resources.
        // show/hide a TextView with that message from where you use the validation method.
        final String prijmeni = editPrijmeni.getEditableText().toString().trim();
        return !prijmeni.isEmpty();
    }

    // I would not declare the activity as a OnClickListener but use anonymous classes in the onCreate method
    // calling method on this class.
    // or if you use ButterKnife you can do so with OnClick annotations.
    // This is to prevent the use of switch which is not great code.
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lnkLogin:
                Intent intent = new Intent(Registrace.this, Login.class);
                startActivity(intent);
                break;
        case R.id.btnRegistrace:
            Toast.makeText(this, "Registrace", Toast.LENGTH_SHORT).show();

            final String prijmeni = editPrijmeni.getEditableText().toString().trim();
            if (this.validujPrijmeni()) {
                Toast.makeText(this, prijmeni, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Zadej příjmení", Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }

}