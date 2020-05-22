MyActivity.java
public class MyActivity extends Activity{


      private class MyWorker extends AsyncTask<SomeDataObject, Integer, SomeDataListObject>{
            @Override
            protected MyFragment doInBackground(SomeDataObject... params) {
                 // in here we use SomeDataObject to generate the SomeDataListObject
                 return MyDataCruncher.processData(someDataObject);
                 // see it's a static method, process A and generates B, that's all.
                 // but very important that it's its own class, separate from Activity and Fragment
            }

            @Override
            protected void onPostExecute(SomeDataListObject result){
                if(results != null){
                     // Here we create the fragment, pass the data to it and do the transaction
                     getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, MyFrag.newInstance(result)).commit();

                }else{ /* do some error handling or whatever */ }
            }
}