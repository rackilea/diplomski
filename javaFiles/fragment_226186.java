@Override
protected void onPostExecute(String result) {
    if(listener!=null) {
         listener.onTaskCompleted(result);
    }
}