public DownloadManager(String url, File f, EditText editText) {
        this.url1 = url;
        this.f = f;
        sDM = this;
        mHandler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message inputMessage){
                DownloaderThreadPool t = (DownloaderThreadPool) inputMessage.obj;
                //Toast.makeText(android.os.Environment.getApplicationContext(), t.threadMessage, Toast.LENGTH_LONG);

                editText.setText("Some text");
            }
        };
    }