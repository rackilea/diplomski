loginBtn.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
          String Email = emailEdt.getText().toString();
          String Password = passwordEdt.getText().toString();
          login(Email, Password);
       }

}