public void displayFlash() {
    animate = true;
    final Handler handler = new Handler();
    Runnable yourRunnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("Running");
            numFrames++;
            switch (numFrames % 3) {
                case 0:
                    loading.setText("Loading.");
                    break;
                case 1:
                    loading.setText("Loading..");
                    break;
                case 2:
                    loading.setText("Loading...");
                    break;
            }
            handler.postDelayed(this, 500);
        }
    }
    handler.post(yourRunnable);
}