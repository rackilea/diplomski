private class LoginTask extends AsyncTask<Void, Void, Void> { 

        private final ProgressDialog dialog = new ProgressDialog(Rig_ParkingActivity.this);

        @Override
    protected void onPreExecute() { 

            this.dialog.setMessage("Loading ..."); 
            this.dialog.show(); 
        } 


    @Override
    protected Void doInBackground(final Void... unused) { 

      Log.i("Priyanka", "username"+username);
      Log.i("Priyanka", "password"+password);
      String auth=BusinessLogic_login.candidatelogin(username, password); 
      String userid=auth; 
        Log.i("priyanka", "auth"+auth);
        if(auth.equals("0")||(auth.equals("")))
        {
           flag=true;
            Rig_ParkingActivity.this.runOnUiThread(new Runnable() {             
                public void run() {                 
                    final AlertDialog alertDialog51;                    
                  alertDialog51 = new AlertDialog.Builder(Rig_ParkingActivity.this).create();
                    alertDialog51.setMessage(Html
                       .fromHtml("<font color='#00beb4'><b>Enter correct Email or Password</b></font>"));                                                                                                       
                    alertDialog51.setButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                int which) {                            
                        alertDialog51.dismiss();    
                               }
                         });            
                    alertDialog51.setButton2("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                            int which) {
                                        alertDialog51.dismiss();                                                
                       }
                    });                         
                    alertDialog51.show();               
                }
            });     
        }

        return null; // don't interact with the ui! 
    } 

    @Override
    protected void onPostExecute(Void result)  
    {  
            if(!flag)
          {
           Intent intnt=new Intent(getBaseContext(), Tab.class);
          startActivity(intnt);
          }
            if (this.dialog.isShowing()) 
            { 
            this.dialog.dismiss(); 
            }
      } 
  }