public class MyWebAPI implements MyAPI{
  @Override
  public void fetchRemoteData(String input, final Callback c){
        AsyncTask<String,Void,String> task = new AsyncTask<String,Void,String>(){

            @Override
            protected String doInBackground(String... strings) {
                String i = strings[0];

                //---connect, fetch data ----
                String result = "result";

                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                c.onDone(1,s);
            }
        };

      task.execute("new Input url");
    }

  @Override
  public String doStuff(String input){
    return input.replace("i","o");
  }
}