new AsyncTask<String, Integer, List<MyData>>() {
  @Override public void onPreExecute() {
    startMyAnimation();
  }

  @Override public List<MyData> doInBackground(String... urls) {
    List<MyData> data = new ArrayList<>();
    int counter = 0;
    publishProgress(counter);
    for(String url : urls) {
      data.add(getMyDataFromNetwork(url));
      publishProgress(++counter);
    }
    return data;
  }

  @Override public void onPostExecute(List<MyData> result) {
    stopMyAnimation();
    updateMyUiWithData(result);
  }

  @Override public void onProgressUpdate(Integer filesDownloaded) {
    updateUiWithFileCount(filesDownloaded);
  }
}.execute(url1, url2, url3, etc);