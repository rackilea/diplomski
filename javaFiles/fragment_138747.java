@Override
protected Void doInBackground(Void... params) { //sort this out
     runOnUiThread (new Runnable() { 
     public void run() {
          results = runTest("CustomUseCase");
         }
     }

    return null;
}