public LetterDisplay(Activity activity, TextView textView, String text, int  speed){
    mActivity = activity;
    if(mActivity == null){
        throw new IllegalArgumentException("activity cannot be null in LetterDisplay");
    }
    this.textView = textView;
    if(textView == null){
        throw new IllegalArgumentException("textView cannot be null in LetterDisplay");
    }
    this.text = text;
    if(text == null){
        throw new IllegalArgumentException("text cannot be null in LetterDisplay");
    }
    this.speed = speed;
    if(speed <= 0){
        throw new IllegalArgumentException("speed cannot be lower or equals than 0");
    }
    this.charCount = text.length();
    if(charCount == 0){
        // no error but i print the warning into logcat
        Log.w("LetterDisplay", "The text in the LetterDisplay is empty and nothing will be executed");
    }
}
public void run(){
    if(charCount > 0)
        textView.setText(""); // Clear the text if any exists
    while(currentLetterCount < charCount && isRunning){
        final String textToUpdate = text.substring(0, ++currentLetterCount);
        mActivity.runOnUiThread(new Runnable(){
            public void run(){
                textView.setText(textToUpdate);
            }
        });
        try
        {
            Thread.sleep(speed);
        } catch(InterruptedException e){}
    }
    isRunning = false;
}
public void stopThread(){
    // you can call it in onPause or onStop or in onDestroy method to stop the thread and avoid energy consumption
    isRunning = false;
}
public boolean isRunning(){
    // if you want to check if thread is running
    return isRunning;
}
}