public class MyEasyButNotGoodPracticesBinder {
    public void gimmeHandler(Handler handler) {
        // you got it!
    }
}

IBinder mBinder = new MyEasyButNotGoodPracticesBinder();

public IBinder onBind(Intent intent) {
    return mBinder;
}