@Override
protected void onPostExecute(List<String> mFiveMessagesToDisplay) {
    super.onPostExecute(mFiveMessagesToDisplay);

    mFiveMessages = mFiveMessagesToDisplay; 
    startTextViewRunnableRepeat();
}