public Runnable mUpdateTextViewRunnable = new Runnable() {
    final static int POSTDELAY_INTERVAL = 600;

    @Override
    public void run() {
        updateTextView(mFiveMessages);
        if (! mStopMessageDisplayRepeat) {
            mMessageDisplayRepeatHandler.postDelayed(mUpdateTextViewRunnable, POSTDELAY_INTERVAL);
        }
    }
};