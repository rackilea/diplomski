private void startDownload(int position) {
    DownloadFile downloadFile = new DownloadFile(position);
    downloadFile.execute(url[position]);
}

class DownloadFile extends AsyncTask<String, Integer, String>
{
    private int position:

    public DownloadFile(int position){this.position = position;}

    // ...

    String path = Environment.getExternalStorageDirectory()
                + "/Android/Data/"
                + getApplicationContext().getPackageName() + "/files/" + name[position];
    // ...
}