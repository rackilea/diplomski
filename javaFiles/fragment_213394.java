long referenceId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
if(downloadReference == referenceId) {
Timber.d("Downloading of the new app version complete");
//start the installation of the latest version
Intent installIntent = new Intent(Intent.ACTION_VIEW);
installIntent.setDataAndType(dm.getUriForDownloadedFile(downloadReference),
                                    "application/vnd.android.package-archive")
installIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
startActivity(installIntent);