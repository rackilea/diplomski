public class Register extends AppCompatActivity {

private EditText mEmailField;
private EditText mPasswordField;
private EditText mConfirmPassword;
private Button mRegisterButton;
private FirebaseAuth mAuth;
private FirebaseAuth.AuthStateListener mAuthListener;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    FirebaseApp.initializeApp(this);
    setContentView(R.layout.activity_register);

    mEmailField = findViewById(R.id.registerEmailField);
    mPasswordField = findViewById(R.id.registerPasswordField);
    mConfirmPassword = findViewById(R.id.registerConfirmPassword);
    mRegisterButton = findViewById(R.id.registerButton);
    mAuth = FirebaseAuth.getInstance();


    // https://stackoverflow.com/questions/10936042/how-to-open-layout-on-button-click-android
    Button register = (Button) findViewById(R.id.navigate_to_login);
    register.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            Intent myIntent = new Intent(view.getContext(), Login.class);
            startActivityForResult(myIntent, 0);
        }
    });

    mRegisterButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startRegister();
        }
    });
}

@Override
protected void onStart() {
    super.onStart();
}

private void startRegister() {
    String email = mEmailField.getText().toString();
    String password = mPasswordField.getText().toString();
    String confirmPassword = mConfirmPassword.getText().toString();

    // Check that fields are not empty
    if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {

        Toast.makeText(Register.this, "Email, password or confirm password field cannot be empty.", Toast.LENGTH_LONG).show();
    } else if (!password.equals(confirmPassword)) {

        Toast.makeText(Register.this, "Password and confirm password should match", Toast.LENGTH_LONG).show();
    } else {

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(Register.this, "Password and confirm password should match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}