yourButtonLogin.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View v) {
        String username = yourEditTextUsername.getText().toString();
        String password = yourEditTextPassword.getText().toString();
        Intent intent = new Intent(this,nonActivityClass.class);
        intent.putExtra("username",username);
        intent.putExtra("password",password);
        startActivity(intent);
    }
});