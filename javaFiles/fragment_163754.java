public final class Calculator extends AsyncTask<Void, Void, Void> {

Context context;
calcCallback mCallback;

public Calculator(Context c) {
    this.context = c;
    this.mCallback = (calcCallback) c;
}

//The main class needs to implement this interface

public interface calcCallback {
    Void calcDone();
    Void calcStarted();
    //Other methods if necessary
}

@Override
protected Boolean doInBackground(Void... params) {
    mCallback.calcStarted();
    //Your calculations here
    mCallback.calcDone();
    return null;
}
}