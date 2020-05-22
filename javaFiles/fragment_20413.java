public void updateTextView(List<String> mMessages) {
    mNextTextViewToUse = mTextViewArrayList.get(mCurrentMessageIndex);
    mNextMessageToDisplay = mMessages.get(mCurrentMessageIndex);

    mNextTextViewToUse.startAnimation(mFadeOutAnimation);
    if (mCurrentMessageIndex == 4) {
        mStopMessageDisplayRepeat = true;
    } else {
        mCurrentMessageIndex++;
    }
}