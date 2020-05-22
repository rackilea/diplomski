@Override
protected void onProgressUpdate(ObserverStatus... values) {
    super.onProgressUpdate(values);
    setChanged();
    notifyObservers(values[0]);
}