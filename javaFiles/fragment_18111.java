/**
* Display a custom toast with some message provided as a function parameter
*
* @param activity An {@link Activity} where the toast message will be shown
* @param msg      a {@link String} that holds the message to be shown as a Toast
* @throws IllegalArgumentException if a null activity is passed to the function
* @apiNote If a null String is passed as a #msg parameter, then this function shows a default text (no_toast)
*/
public static void showToast(Activity activity, String msg) {

    if (activity == null) {
        throw new IllegalArgumentException("The passed in activity cannot be null");
    }

    if (msg == null) {
        msg = activity.getString(R.string.no_msg);
    }

    ToastLayoutBinding toastLayout = DataBindingUtil.inflate(
            activity.getLayoutInflater(), R.layout.toast_layout, null, false);
    toastLayout.setMsg(msg); // Set the toast message here

    Toast toast = new Toast(activity);
    toast.setView(toastLayout.getRoot());
    toast.setGravity(Gravity.TOP, 0, 200);
    toast.setDuration(Toast.LENGTH_LONG);
    toast.show();
}