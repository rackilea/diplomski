public class DateTimeComponent extends RelativeLayout {
    private Activity activity;

    public DateTimeComponent(Activity act){
        activity = act;
    }

    public void someListener() {
        activity.showDialog(...);
    }

}