Runnable runnable = new Runnable() {
        @Override
        public void run() {
            lastBackupDataObject = getBackupDataObjectFromFile(file);   
            parsingCompleteHandler.sendEmptyMessage(0);
        }
    };
    Thread parsingThread = new Thread(runnable);
    parsingThread.start();