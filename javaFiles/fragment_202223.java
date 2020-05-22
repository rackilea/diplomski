public ExtendedActivity extends ACTIVITY
{
    public ExtendedActivity()
    {
        if (MODE == MODE.ANDROID) {
            include android.app.Activity;
            this.callFunction1();
        }
        else {
            include com.WazaBe.HoloEverywhere.sherlock.SActivity;
            this.callFunction2();
        }
    }
}