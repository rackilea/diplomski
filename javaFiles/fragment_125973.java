Submit_btn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {

final String Password_string = Password_txt.getText().toString();
final String VerifyPassword_string = VerifyPassword_txt.getText().toString();
    if (!Password_string.equals(VerifyPassword_string)) {
        Error_txt.setText("Passwords must be matching");

    } else {
        Error_txt.setText("No Error");
    }
}