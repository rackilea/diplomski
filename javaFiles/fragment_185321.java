final Context c = this;
dlbutton.setOnClickListener(new View.OnClickListener() {
   @Override
    public void onClick(View view) {
        //...
        DownloadManager manager =(DownloadManager) c.getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }
});