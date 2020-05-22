File apkFile = new File(Environment.getExternalStorageDirectory()
                  .getAbsolutePath() + "/app-release.apk");
Intent install_intent = new Intent(Intent.ACTION_VIEW);
install_intent.setDataAndType(Uri.fromFile(apkFile), 
     "application/vnd.android.package-archive");
startActivity(install_intent);