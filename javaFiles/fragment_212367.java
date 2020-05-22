public Pdf(Context context, String url, String fileName) {
    this.context = context;
    this.url = url;
    this.fileName = fileName;
    init();
}


private void init() {
    downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
    context.registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    Download_Uri = Uri.parse(url);
}

public void checkAndDownload() {
    if (isStoragePermissionGranted()) {
        if (isExistPdfFile()) {
            openGeneratedPDF();
        }else{
            downloadPdf();
        }

    }
}

public void permissionGranted(int[] grantResults) {
    if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
        downloadPdf();
    }
}

private boolean isStoragePermissionGranted() {
    if (Build.VERSION.SDK_INT >= 23) {
        if (context.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            return false;
        }
    } else {
        return true;
    }
}


public BroadcastReceiver onComplete = new BroadcastReceiver() {
    public void onReceive(Context ctxt, Intent intent) {
        isCompeleted = true;
        openGeneratedPDF();
    }

};

private boolean isExistPdfFile() {
    File target = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    file = new File(target, DIRECTORY_PDF_NAME + "/" + fileName + ".pdf");
    if (file.exists()) {
        return true;
    }else{
        return false;
    }
}

private void openGeneratedPDF() {
    if (isExistPdfFile()) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
        Log.e("uri is",uri.toString());
        intent.setDataAndType(uri, "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        try {
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "برنامه‌ای برای نمایش فایل PDF وجود ندارد", Toast.LENGTH_LONG).show();
        }
    }else {
        Toast.makeText(context,"فایل مورد نظر یافت نشد",Toast.LENGTH_LONG).show();
    }
}

private void downloadPdf() {
    DownloadManager.Request request = new DownloadManager.Request(Download_Uri);
    request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
    request.setAllowedOverRoaming(true);
    request.setVisibleInDownloadsUi(true);
    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, Constant.DIRECTORY_PDF_NAME + "/" + fileName + ".pdf");
    refid = downloadManager.enqueue(request);
    Log.e("OUT", "" + refid);
}

public boolean getIsCompeleted() {
    return isCompeleted;
}