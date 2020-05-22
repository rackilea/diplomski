ImageView exImage = null;

long startTime = 0;
long pauseTime = 0;
long pauseStartTime = 0;

List<Integer> animList = new ArrayList<>();
int animIt = 0;        

Handler timerHandler = new Handler();
Runnable timerRunnable = new Runnable() {
    @Override
    public void run() {

        long millis = System.currentTimeMillis() - startTime - pauseTime;
        double dSecs = (double) (millis / 100);
        int pace = 10;

        if (dSecs % pace == 0.0 && !animList.isEmpty()) {
            animIt = (animIt == animList.size() - 1) ? 0 : animIt + 1;
            exImage.setBackgroundResource(animList.get(animIt));
        }
        timerHandler.postDelayed(this, 100);
    }
};