class checkAyscTask implements Runnable {
    AsyncTask<Void, Void, Boolean> mAT;
    Context context;

    public checkAyscTask(AsyncTask<Void, Void, Boolean> at) {
        mAT = at;
    }

    @Override
    public void run() {
        mHandler.postDelayed(runnable, 60000);
        // After 60sec the task in run() of runnable will be done
    }

    Handler mHandler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (mAT.getStatus() == Status.RUNNING || mAT.getStatus() == Status.PENDING) {
                mAT.cancel(true); //Cancel Async task or do the operation you want after 1 minute
            }
        }
    };
}

task_GetGPS = new GetGPShotfix(); 
task_GetGPS.execute();
checkAyscTask chk = new checkAyscTask(task_GetGPS);
// Thread keeping 1 minute time watch
(new Thread(chk)).start();