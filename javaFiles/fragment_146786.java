private Toast mToast = null; // <-- keep this in your Activity or even in a custom Application class

//... show one Toast
if (mToast != null) mToast.cancel();
mToast = Toast.makeText(context, text, duration);
mToast.show();

//... show another Toast
if (mToast != null) mToast.cancel();
mToast = Toast.makeText(context, text, duration);
mToast.show();

// and so on.