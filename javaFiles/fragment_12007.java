if (test.get(0) == "e") {
    loadImage("https://something.something/something.jpg");
}
if (test.get(1) == "a") {
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            //Do something after 3sec (3000 = 3 sec)
            loadImage("https://something.something/something2.jpg");
        }
    }, 3000);
}