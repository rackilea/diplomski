private void doSometingAfterToast(int toastLength){
    new android.os.Handler(getMainLooper()).postDelayed(new Runnable() {
        @Override
        public void run() {
            doSomething();
        }
    }, toastLength);
}