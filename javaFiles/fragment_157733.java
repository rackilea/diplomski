Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
    emailIntent.setType("image/jpeg");
    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
    //emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,body);
    emailIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(new StringBuilder()
    .append("I think you'll like this ")
    .append(wineName).append(".")
    .append("<br /><br />Scanned it with the ")
    .append(bottleRating+tastingNote)

    emailIntent.putExtra(Intent.EXTRA_STREAM,Uri.parse("file://"+winePic));

    final PackageManager pm = ShareWineActivity.this.getPackageManager();
    final List<ResolveInfo> matches = pm.queryIntentActivities(emailIntent, 0);
    ResolveInfo best = null;
    for (final ResolveInfo info : matches)
        if (info.activityInfo.packageName.endsWith(".gm")|| info.activityInfo.name.toLowerCase().contains("gmail"))
            best = info;
    if (best != null)
        emailIntent.setClassName(best.activityInfo.packageName,best.activityInfo.name);
    startActivityForResult(emailIntent, 2015);