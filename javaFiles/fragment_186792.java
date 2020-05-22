private void startDownload() {
    progressBar.setVisibility(View.VISIBLE);

    asyncTask = new DownloadFilesTask();
    asyncTask.execute(<urls for download>);
}