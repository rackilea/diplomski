// DISPLAY ON CLICK HANDLER
displayButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            progressDialog().show();
        Thread thread= new Thread( new Runnable() {
            public void run() {
                postData();
                myHandler.sendEmptyMessage(0);
            }
        });
        thread.setDaemon(true);
        thread.start();
        }
});