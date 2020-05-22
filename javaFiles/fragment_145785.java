class ActivityA extends Activity {
  myButton.setOnClickListener(new OnClickListener() {   
    public void onClick(View v) {
      //get stuff and use the onPostExecute inside the APIWrapper
      new APIWrapper().getItems("Category A", new MyCallback() {
        public void gotItems(String result) {
          // bla bla bla
        }
      });
  }});