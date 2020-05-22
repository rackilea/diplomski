if (AppController.RunningTime <= 0) {
    handler.removeCallbacks(runnable);
    openTimeUpDailog(mContext);
} else {
    handler.postDelayed(this, 1000);
}