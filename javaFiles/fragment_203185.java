Timer autoRefresh;
autoRefresh=new Timer();
    autoRefresh.schedule(new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                public void run() {
                    getTimeLineData(token, page);
                }
            });
        }
    }, 0, your_time_in_milliseconds);