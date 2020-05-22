myWebView .setDownloadListener(new DownloadListener() {

        public void onDownloadStart(String url, String userAgent,
            String contentDisposition, String mimetype,
                                       long contentLength) {

                Request request = new Request(Uri.parse(url));
                request.allowScanningByMediaScanner();

                    request.setNotificationVisibility(
                    DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    request.setDestinationInExternalPublicDir(
                    Environment.DIRECTORY_DOWNLOADS,    //Download folder
                    "download");                        //Name of file


                    DownloadManager dm = (DownloadManager) getSystemService(
                    DOWNLOAD_SERVICE);

                    dm.enqueue(request);  

        }
    });