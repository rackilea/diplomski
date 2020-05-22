public class SecondClass extends AsyncTask<String, Void, String> {
public interface Callback {
    public void update(String result);
}
Callback mCallback;

    public SecondClass(Callback callback) {
        super();
    mCallback = callback;
    }

    @Override
    protected String doInBackground(String... params) {
    String result = null;
        //do your stuff and save result
        return result;
    }

@Override
    protected void onPostExecute(String result) {
    if(mCallback != null)
    mCallback.update(result)
        super.onPostExecute(e);
    }
}

public class FirstClass implements SecondClass.Callback{
@Override
public void update(String result){
      //do your stuff with result
}

return_type someMethod(){
  SecondClass sc = new SecondClass(this) ;
  sc.execute(someurl);
  }
  }