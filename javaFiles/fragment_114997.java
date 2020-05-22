private void executeDownloadsAndWriteToDataBase() {
        runnable = null; //this is what was reason for the memory leak, the runnable was recreating itself
        runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    downloadData();
                    mHandler.postDelayed(this, 1000);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {
                    //also call the same runnable
                    mHandler.postDelayed(this, 20000);
                }
            }
        };

        mHandler.postDelayed(runnable, 30000);
    }