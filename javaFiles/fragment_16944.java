public static void ErrorToast(int errorCode) {
    String errorString = null;
    if (errorCode == 1) {
        errorString = App.getContext().getString(R.string.error_tooManyFieldsEmpty);
    }
    if (errorCode == 2) {
        errorString = App.getContext().getString(R.string.error_featureComingSoon);
    }
    if (errorCode == 3) {
        errorString = App.getContext().getString(R.string.error_SwitchBreak);
    } else {
        errorString = "Wrong Error Code";
    }
    Toast errormsg = Toast.makeText(App.getContext(), errorString, Toast.LENGTH_SHORT);
    errormsg.setGravity(Gravity.CENTER, 0, 0);
    errormsg.show();
}