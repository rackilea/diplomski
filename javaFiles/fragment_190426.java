public class ToastUtils {

    private ToastUtils() { /*nobody needs to instantiate this ever*/ }

    public static void makeToast(Context context, boolean success, String text) {
        LayoutInflater inflater = LayoutInflater.from(context);
        int layoutRes = success ? R.layout.toast_layout_success : R.layout.toast_layout_error;

        View layout = inflater.inflate(layoutRes, null, false);

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(text);

        Toast toast = new Toast(context);
        toast.setGravity(Gravity.BOTTOM|Gravity.FILL_HORIZONTAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}