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


    mAuthListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

            if (firebaseAuth.getCurrentUser() != null) {
                 startActivity(new Intent(Register.this, UploadActivity.class));
            }
        }
    };

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

    mAuth.addAuthStateListener(mAuthListener);
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

        mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                Toast.makeText(Register.this, "Success", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(Register.this, "Failure", Toast.LENGTH_LONG).show();
            }
        });
    }
}