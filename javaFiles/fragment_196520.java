protected void onProgressUpdate(Integer... progress) {
    setProgressPercent(progress[0]);
}
protected void onPostExecute(Long result) {
    showDialog("Downloaded " + result + " bytes");
}