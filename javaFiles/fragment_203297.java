ProgressDialog pd = new ProgressDialog(this); 
pd.setTitle(title);
pd.setMessage(message);
pd.show();

...

pd.dismiss(); //Use it when the task is over