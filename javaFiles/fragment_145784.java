class ActivityA extends Activity {
  myButton.setOnClickListener(new OnClickListener() {   
    public void onClick(View v) {
      //get stuff and use the onPostExecute inside the APIWrapper
      new APIWrapper().getItems("Category A", new MyGetItemsCallBack());
  }}); 

  private class MyGetItemsCallBack implements MyCallback {
    public void gotItems(String result) {
      // bla bla bla
    }
  }
}