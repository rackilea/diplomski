@Override
protected void onProgressUpdate(Long... values) {
    long progress = values[0];
    // update UI here
}
// if you choose object Integer
@Override
protected void onProgressUpdate(Integer... values) {
    int progress = values[0];
    // update UI here
}