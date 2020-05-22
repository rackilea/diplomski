interface Callback<T> {
  void run(T arg);
}

class ActivityA extends Activity {
  myButton.setOnClickListener(new OnClickListener() {   
    public void onClick(View v) {
      //get stuff and use the onPostExecute inside the APIWrapper
      new APIWrapper().getItems("Category A", new Callback<String>() {
        public void run(String result) {
          // bla bla bla
        }
      });
  }});