public static void setInVisLife3C() {           
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            life3C.setVisibility(View.INVISIBLE);
        }
    });
}