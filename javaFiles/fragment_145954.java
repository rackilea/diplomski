public interface MyAPI {
 //--this method runs an AsyncTask and calls supplied Callback object's methods when done
 public void fetchRemoteData(String input, Callback c);

 //--this method just processes input string locally and returns it
 public String doStuff(String input);
}

public interface Callback{
  public void onDone(int doneWhatCode, String result);
}