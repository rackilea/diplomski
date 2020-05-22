public class MyTask extends AsyncTask<Void,Integer,String>
{
    @override
    public String doInBackground(Void... params)
    {
         //do your background processes
         ...
         publishProgress(someInteger); //for updating progress bar
         ...
         return result;
    }

    @override
    public void onProgressUpdate(Integer... params)
    {
         //do your progress bar update with params[0]
    }

    @override
    public void onPostExecute(String.. params)
    {
         //do something with the results of doInBackground stored in params[0]
    }
}