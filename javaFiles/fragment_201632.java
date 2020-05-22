public final class MyActivityLogic {

    private MyApp mMyApp;

    public MyActivityLogic(MyApp pMyApp) {
        mMyApp = pMyApp;
    }

    public MyApp getMyApp() {
        return mMyApp;
    }

    public void onClick(View pView) {
        getMyApp().setNewState();
    }
}

public final class MyActivity extends Activity {

    // The activity logic is in mLogic
    private final MyActivityLogic mLogic;

    // Logic is created in constructor
    public MyActivity() {
        super(); 
        mLogic = new MyActivityLogic(
            (MyApp) getApplicationContext());
    }

    // Getter, you could make a setter as well, but I leave
    // that as an exercise for you
    public MyActivityLogic getMyActivityLogic() {
        return mLogic;
    }

    // The method to be tested
    public void onClick(View pView) {
        mLogic.onClick(pView);
    }

    // Surely you have other code here...

}