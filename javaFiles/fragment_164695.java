public void run() {
    if(result != null){
        if (result.equals(SERVER_RES_RES_SIGN_UP_SUCCESFULL)) {
            Toast.makeText(getApplicationContext(),R.string.signup_successfull, Toast.LENGTH_LONG).show();
            showDialog(SIGN_UP_SUCCESSFULL);
        }
        else if (result.equals(SERVER_RES_SIGN_UP_USERNAME_CRASHED)){
            Toast.makeText(getApplicationContext(),R.string.signup_username_crashed,       Toast.LENGTH_LONG).show();
            showDialog(SIGN_UP_USERNAME_CRASHED);
        }
        else  //if (result.equals(SERVER_RES_SIGN_UP_FAILED))
        {
            Toast.makeText(getApplicationContext(),R.string.signup_failed, Toast.LENGTH_LONG).show();
            showDialog(SIGN_UP_FAILED);
        }else{
            //result == null
        }
    }
}