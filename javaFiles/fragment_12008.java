if (test.get(0) == "e") {
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            //Do something after 3sec (3000 = 3 sec)
            loadImage("https://something.something/something.jpg"); // image 1 
        }
    }, 3000);
}
if (test.get(1) == "a") {
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            //Do something after 3sec (3000 = 3 sec)
            loadImage("https://something.something/something2.jpg"); // image 2
        }
    }, 3000);
}