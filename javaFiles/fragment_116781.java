login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String email = ed1.getText().toString().trim();
        String password = ed2.getText().toString().trim();
         final String log_id = u_id.getText().toString();
        if(email.isEmpty()){
            ed1.setError("Fill this field");
            ed1.requestFocus();
        }else if(password.isEmpty()){
            ed2.setError("Fill this field");
            ed2.requestFocus();
        } else if(log_id.isEmpty()){
            u_id.setError("Fill this field");
            u_id.requestFocus();
        } else {
                login();
                Intent i = new Intent(MainActivity.this,fullview.class);
                Bundle b =new Bundle();
                b.putString("text", u_id.getText().toString().trim());
                i.putExtras(b);
                startActivity(i);
           }


        }