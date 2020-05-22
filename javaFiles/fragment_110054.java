public class OKActivity extends Activity {

EditText newPassword;
String newUserPassword;

@Override 
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ok);

    newPassword = (EditText) findViewById(R.id.new_password);
    //do not retrieve password here
    Button changePassword = (Button) findViewById(R.id.button_change);

    changePassword.setOnClickListener(new OnClickListener() {

        @Override 
        public void onClick(View arg0) {
            //retrieve password here. Assuming user has entered some string before clicking on changePassword button
            newUserPassword = newPassword.getText().toString();
            getpasswordSharedPreferences(); 
            setSharedPreferences(); 

        } 
    }); 

} 
private String getpasswordSharedPreferences() {

    SharedPreferences userPassword = getSharedPreferences("USER_PASSWORD", MODE_PRIVATE);
    String password = userPassword.getString("THE_PASSWORD", "123");
    return password;

} 

private void setSharedPreferences() { 
    SharedPreferences userPassword = getSharedPreferences("USER_PASSWORD", MODE_PRIVATE);
    SharedPreferences.Editor password_edior = userPassword.edit();
    password_edior.putString("THE_PASSWORD", newUserPassword);
    password_edior.commit();
    Toast.makeText(OKActivity.this, "Password Change Succesful", Toast.LENGTH_SHORT).show();
    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(OKActivity.this);
        dialogBuilder.setIcon(R.drawable.ic_launcher);
        dialogBuilder.setTitle("Done!");
        dialogBuilder.setMessage(newUserPassword);
        dialogBuilder.setPositiveButton("OK", null);
        dialogBuilder.show();
}