File toInstall = new File(appDirectory, appName + ".apk");
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
Uri apkUri = FileProvider.getUriForFile(activity, BuildConfig.APPLICATION_ID + ".provider", toInstall);
Intent intent = new Intent(Intent.ACTION_INSTALL_PACKAGE);
intent.setData(apkUri);
intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
activity.startActivity(intent)
} else {
Uri apkUri = Uri.fromFile(toInstall);
Intent intent = new Intent(Intent.ACTION_VIEW);
intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
activity.startActivity(intent);