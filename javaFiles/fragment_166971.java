public class VerifyPhoneActivity extends AppCompatActivity {
private String verificationId;
private FirebaseAuth mAuth;
FirebaseAuth.AuthStateListener mAuthListener;
DatabaseReference users;
ProgressBar progressBar;
TextInputEditText editText;
AppCompatButton buttonSignIn;
SharedPreferences prefs ;
SharedPreferences.Editor editor;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    prefs = getApplicationContext().getSharedPreferences("USER_PREF",
            Context.MODE_PRIVATE);
    editor = prefs.edit();

    //add this line
    if(prefs.getString("phoneNumber", null) != null)
      startActivity(new Intent(this, DriverHomeActivity.class));

    setContentView(R.layout.activity_verification_code);


    mAuth = FirebaseAuth.getInstance();

    progressBar = findViewById(R.id.progressbar);
    editText = findViewById(R.id.editTextCode);
    buttonSignIn = findViewById(R.id.buttonSignIn);

    String phoneNumber = getIntent().getStringExtra("phoneNumber");
    sendVerificationCode(phoneNumber);

    buttonSignIn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String code = editText.getText().toString().trim();

            if (code.isEmpty() || code.length() < 6) {

                editText.setError("Enter code...");
                editText.requestFocus();
                return;
            }
            verifyCode(code);
        }
    });

}

private void verifyCode(String code) {
    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
    signInWithCredential(credential);
}

private void signInWithCredential(PhoneAuthCredential credential) {
    mAuth.signInWithCredential(credential)
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){

      //insert data if task is successful
                       editor.putString("phoneNumber", phoneNumber);
                       editor.apply();

                        Intent intent = new Intent(VerifyPhoneActivity.this, DriverHomeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                        startActivity(intent);


                    }else {
                        Toast.makeText(VerifyPhoneActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }
            });
}

private void sendVerificationCode(String number) {
    progressBar.setVisibility(View.VISIBLE);
    PhoneAuthProvider.getInstance().verifyPhoneNumber(
            number,
            60,
            TimeUnit.SECONDS,
            TaskExecutors.MAIN_THREAD,
            mCallBack
    );

    progressBar.setVisibility(View.GONE);
}

private PhoneAuthProvider.OnVerificationStateChangedCallbacks
        mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

    @Override
    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        super.onCodeSent(s, forceResendingToken);
        verificationId = s;
    }

    @Override
    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        String code = phoneAuthCredential.getSmsCode();
        if (code != null) {
            editText.setText(code);
            verifyCode(code);
        }
    }

    @Override
    public void onVerificationFailed(FirebaseException e) {
        Toast.makeText(VerifyPhoneActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        progressBar.setVisibility(View.GONE);
    }
};