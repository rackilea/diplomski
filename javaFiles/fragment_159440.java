protected void onPostExecute(String validUser) {

        pDialog.dismiss();
        if(validUser)
        {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            finish();
        }


         params.clear();
            }
        }