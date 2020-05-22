public void run() {
    while (mp != null && mPosition < mTotal) {
        try {
            Thread.sleep(500); // you can modify sleep time for better accuracy
            if (mp.isPlaying()) {
                mPosition = mp.getCurrentPosition();
                if (mPosition == mYourStopPoint) { //remember to set mYourStopPoint
                    mp.stop();
                    break;
                }
            }
        } catch (InterruptedException e) {
            return;
        } catch (Exception e) {
            return;
        }

    }
}