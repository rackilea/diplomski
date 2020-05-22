if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
    i.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
  }
  else if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN) {
    ClipData clip=
      ClipData.newUri(getContentResolver(), "A photo", outputUri);

    i.setClipData(clip);
    i.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
  }
  else {
    List<ResolveInfo> resInfoList=
      getPackageManager()
        .queryIntentActivities(i, PackageManager.MATCH_DEFAULT_ONLY);

    for (ResolveInfo resolveInfo : resInfoList) {
      String packageName = resolveInfo.activityInfo.packageName;
      grantUriPermission(packageName, outputUri,
        Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
    }
  }