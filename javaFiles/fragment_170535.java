// First, you're instantiating the object
AlertUtils alertUtils = new AlertUtils(getContext());

// then you're calling the method
int pressedButton = alertUtils.ShowAlertWithTwoButtons("title", "message", "yes", "no");

// which will return pressedButton as 0

// then you calling the method again after clicked yes or no
int anotherPressedButton = alertUtils.ShowAlertWithTwoButtons("title", "message", "yes", "no");

// which will not zero. But can be -1, -2, -3 like in the
// https://developer.android.com/reference/android/content/DialogInterface.html