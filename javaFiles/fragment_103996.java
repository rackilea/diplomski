public static final String INTENTKEY_USERNAME = "IK_USERNAME";
public static final String INTENTKEY_USERID = "IK_USERID";
public static final String INTENTKEY_STRINGUSERID = "IK_USERIDSTRING";

Button mloginbtn;
EditText mEmail,mPassword;
Context mContext;
DatabaseHelper mDB;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    mContext = this;
    mloginbtn = this.findViewById(R.id.loginbtn);
    mEmail = this.findViewById(R.id.email);
    mPassword = this.findViewById(R.id.password);
    mDB = new DatabaseHelper(this);

    mloginbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            handleAuthentication();
        }
    });
}

private void handleAuthentication() {
    if (mDB.authenticateUser(mEmail.getText().toString(),mPassword.getText().toString())) {
        User u = mDB.getUser(mEmail.getText().toString(),mPassword.getText().toString());
        Intent i = new Intent(mContext,HomeActivity.class);
        i.putExtra(INTENTKEY_USERNAME,u.getName());
        i.putExtra(INTENTKEY_USERID,u.getLongId());
        i.putExtra(INTENTKEY_STRINGUSERID,u.getId());
        startActivity(i);
        finish();
    }
}