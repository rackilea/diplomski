public class MyClass extends Activity {

  //member variable for the username the user enters:
  User userEnteredUser;

  public class FetchUserDataAsyncTask extends AsyncTask<Void, Void, User> {
    RequestHandler rh = new RequestHandler(); //this is the class i use to do de server conection
    User user;
    User ret_user;


    public FetchUserDataAsyncTask(User user){
        this.user  = user;
    }


    @Override
    protected void onPostExecute(User user) {
        super.onPostExecute(user);

   //I WANT THIS USER IN MY MAIN THREAD, TO WORK WITH ITS ATTRIBUTES
       processValue(user);  //added

    }



    @Override
    protected User doInBackground(Void... params) {
        try {
            HashMap<String, String> dataToSend = new HashMap<>();
            dataToSend.put("username", user.username);
            dataToSend.put("password", user.password);
            ret_user = rh.sendGetRequest("myadresstophp.php", dataToSend);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret_user;
    }
   }

  private void getValue()
  {
      EditText et = (EditText) findViewById(R.id.username);
      userEnteredUser.username = et.getText().toString(); //something like this.... replace with your syntax
      new FetchUserDataAsyncTask(userEnteredUser).execute();
  }

  private void processValue(User userFromServer) 
  {
    if (userEnteredUser.equals(userFromServer)) {
      //Users match! Yay!
    }
  }
}