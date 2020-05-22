Class UIUtils{
public static void simpleToast(String message, int duration,Context context) {
toast = Toast.makeText(context, message, duration);
toast.setGravity(Gravity.CENTER, 0, 0);
toast.show();
}