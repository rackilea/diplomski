private class FetchData extends AsyncTask<String, FetchDataParams, String> {

    View parentView;

    public FetchData(View parentView){
      this.parentView = parentView;
    }

    @Override
    protected String doInBackground(String... routeSelected) {
      //code removed here...

      int progress = (int)((i / (float)totalpoints) * 100);
      String progressString = progress + "/100%";
      publishProgress(new FetchDataParams(outputFile.length(), progress, progressString));

      //code removed here...
      return filePath;
    }
    //This is what I figured it should be doing, this does not work inside a listAdapter
    protected void onProgressUpdate(FetchDataParams... params) {
      setFileSize(parentView, params[0].fileLength);
      setProgressBar(parentView, params[0].progress);
      setTextProgress(parentView, params[0].progressString);
    }

    @Override
    protected void onPostExecute(String routeSelected) {
      super.onPostExecute(routeSelected);      
    }
  }