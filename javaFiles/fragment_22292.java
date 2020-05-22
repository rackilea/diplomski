public class TyperTask extends AsyncTask<Void, String, Void> {
    TextView mTextView;
    String mMessage;
    int mTypingDelay;

    TyperTask(TextView textView, String message, int typingDelay) {
        this.mTextView = textView;
        this.mMessage = message;
        this.mTypingDelay = typingDelay;
    }

    @Override
    protected Void doInBackground(Void... params) {
        for (int i = 0; i < mMessage.length(); i++) {
            publishProgress(String.valueOf(mMessage.charAt(i)));
            try {
                Thread.sleep(mTypingDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... typedChar) {
        mTextView.append(typedChar[0]);
    }

}