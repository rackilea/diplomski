if(!etPW.getText().toString().equals(etCPW.getText().toString())){
                Toast.makeText(MainActivity.this,"Password Does NOT\n"+"Match Confirm Password",Toast.LENGTH_LONG).show();
                etPW.setText("");
                etCPW.setText("");
                etPW.requestFocus();
                return;
            }