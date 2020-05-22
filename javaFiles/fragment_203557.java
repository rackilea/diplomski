public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private User user;
    private EditText usernameTextView;
    private EditText fullnameTextView;
    private EditText emailTextView;
    private EditText passwordTextView;
    private RadioButton radioMale;
    private RadioButton radioFemale;
    private String selectedGender;
    private DemeaSQL demeaSQL;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        findAllViewsById();
        initListeners();
        intitObjects();
    }

    public void findAllViewsById(){
        signupButton = findViewById(R.id.signUpButton);
        usernameTextView = findViewById(R.id.usernameTextField);
        fullnameTextView = findViewById(R.id.fullnameTextField);
        emailTextView = findViewById(R.id.emailTextField);
        passwordTextView = findViewById(R.id.passwordTextField);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpButton:
                postDataToSQLite();
                break;
        }
    }

    public void intitObjects(){
        demeaSQL = new DemeaSQL(MainActivity.this);
        user = new User();
    }

    private void initListeners() {
        signupButton.setOnClickListener(this);
    }

    public void postDataToSQLite(){

        user.setUsername(usernameTextView.getText().toString());
        user.setFullname(fullnameTextView.getText().toString());
        user.setEmail(emailTextView.getText().toString());
        user.setPassword(passwordTextView.getText().toString());

        if(radioMale.isChecked()){
            selectedGender= radioMale.getText().toString();
        }else if(radioFemale.isChecked()){
            selectedGender=radioFemale.getText().toString();
        }

        user.setGender(selectedGender);
        demeaSQL.addUser(user);

        if( demeaSQL != null){
            //Log.i("Database content", (demeaSQL.getAllUser().toString()));
            StringBuilder sb = new StringBuilder();
            for(User u: demeaSQL.getAllUser()) {
                sb.append("ID=" +u.getId() +
                        " Username=" + u.getUsername() +
                        " Fullname=" + u.getFullname() +
                        " Email=" + u.getEmail() +
                        " Password=" + u.getPassword() );
                sb.append("\n");
            }
            Log.d("USERINFO",sb.toString());
        }
        else{
            Log.i("Database Err", "Database Error");
        }
    }
}