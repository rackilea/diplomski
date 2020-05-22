@Override
    public void onLogin(String email, String password, Boolean saveAccount){

        //remove the leading ProgessDialog here...it is hiding your member 'dialog'
        //dialog = new ProgressDialog(getApplicationContext());
        ProgressDialog dialog = new ProgressDialog(getApplicationContext());
        dialog.setMessage("Signing...");
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);

        new Login().execute(email, password);
    }