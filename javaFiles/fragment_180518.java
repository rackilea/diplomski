protected void onPostExecute(String file_url) {
        // dismiss the dialog once done

     if(pDialog.isShowing()){
       pDialog.dismiss();
      }
        editText.setText("");
      AlertDailog.Builder builder = new AlertDialog.Builder(Activity.this);
             builder.setText("");
             builder.setMessege("");
             builder.create().show();
        });