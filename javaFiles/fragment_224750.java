private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
                mCurrentLapse = SystemClock.uptimeMillis() - mStartTime;
                //
                long displayTime = mTime + mCurrentLapse;
                .
                .
                .