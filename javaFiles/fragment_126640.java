@SuppressLint("NewApi")
public void init(...) {
    // make a call to check that the number of cameras is not 0
    // AND CONTINUE IF GOOD (TRUE)
    if(parseServerInfo(receivedData)){
        prVideoDisplayHandler.removeCallbacks(prDisplayVideoTask);
        prVideoDisplayHandler.postDelayed(prDisplayVideoTask, prDelay);
    }
}