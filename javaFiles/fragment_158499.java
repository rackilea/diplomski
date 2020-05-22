@Override
public void onResumeFragment() {
    new Handler().post(new Runnable() {
        @Override
        public void run() {
            refreshData();
        }
    });
}