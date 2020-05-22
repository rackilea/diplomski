private Handler handler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case Constants.TASK_FINISHED:
                somefunc();
                break;                
        }
    }
};

SaveAdDetail task = new SaveAdDetail(handler);
task.execute();