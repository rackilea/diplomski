protected Void doInBackground(String.. params ) {
     publishProgress("sentence 1");
     //do some time consuming task 
     //..
     publishProgress("sentence 2");
     //do some more time consuming task 
     //..
     publishProgress("sentence 3");
     //do some more time consuming task 
     //..
 }

 protected void onProgressUpdate(String... progress) {
     myDialog.setMessage(progress[0]);
 }