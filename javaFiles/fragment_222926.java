getActivity().runOnUiThread(new Runnable() {
@Override
public void run() {
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {

        @Override
        public void run() {
            startActivity(new Intent(this, NextActivity.class));
        }
    }, x);// here x is time in millisecond 1 second = 1000 millseconds

} });