if(result == true){
                Intent bEmpIntent = new Intent(LoginActivity.this,BasicEmployeeActivity.class);
                startActivity(bEmpIntent);
            }else{
                Toast.makeText(LoginActivity.this,"username or password incorrect",Toast.LENGTH_SHORT).show();
            }