private class DownloadFilesTask extends AsyncTask<String, Integer, Long> {

 // these Strings / or String are / is the parameters of the task, that can be handed over via the excecute(params) method of AsyncTask
 protected Long doInBackground(String... params) {

    String param1 = params[0];
    String param2 = params[1];
    // and so on...
    // do something with the parameters...
    // be careful, this can easily result in a ArrayIndexOutOfBounds exception
    // if you try to access more parameters than you handed over

    long someLong;
    int someInt;

    // do something here with params
    // the params could for example contain an url and you could download stuff using this url here

    // the Integer variable is used for progress
    publishProgress(someInt);

    // once the data is downloaded (for example JSON data)
    // parse the data and return it to the onPostExecute() method
    // in this example the return data is simply a long value
    // this could also be a list of your custom-objects, ...
    return someLong;
 }

 // this is called whenever you call puhlishProgress(Integer), for example when updating a progressbar when downloading stuff
 protected void onProgressUpdate(Integer... progress) {
     setProgressPercent(progress[0]);
 }

 // the onPostexecute method receives the return type of doInBackGround()
 protected void onPostExecute(Long result) {
     // do something with the result, for example display the received Data in a ListView
     // in this case, "result" would contain the "someLong" variable returned by doInBackground();
 }
}