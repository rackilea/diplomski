@Override
protected void onPostExecute(MyClass myObject) {
    super.onPostExecute(myObject);
    // LOG some message or put a break point to see if you get called
    taskListener.onTaskComplete(myObject);
}