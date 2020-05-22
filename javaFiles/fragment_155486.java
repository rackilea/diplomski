new android.os.Handler().postDelayed(
    new Runnable() {
        public void run() {
            Log.i("tag", "This'll run 300 milliseconds later");
        }
    }, 
300);