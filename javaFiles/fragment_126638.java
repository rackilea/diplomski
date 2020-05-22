@SuppressLint("NewApi")
public void init(...) {
    // make a call to check that the number of cameras is not 0
    parseServerInfo(receivedData);    
    // AND CONTINUE NO MATTER WHAT...
    prVideoDisplayHandler.removeCallbacks(prDisplayVideoTask);
    prVideoDisplayHandler.postDelayed(prDisplayVideoTask, prDelay);
}