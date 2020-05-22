pd = new ProgressDialog(this); // I declared pd as a global variable to access it from AsyncTask
pd.setTitle(title);
pd.setMessage(message);
pd.show();
mAuthTask = new UserLoginTask();
mAuthTask.execute((Void) null);