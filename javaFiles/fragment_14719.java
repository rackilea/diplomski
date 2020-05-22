private void shareTray(){
    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
    sharingIntent.setType("text/plain");
    sharingIntent.putExtra(Intent.EXTRA_TEXT, sharedURL);

    Intent receiver=new Intent(getActivityContext, UserSelectedShareBroadcast.class);
    PendingIntent pendingIntent=PendingIntent.getBroadcast(getActivityContext, 0, receiver, PendingIntent.FLAG_UPDATE_CURRENT);

    PackageManager pm=getActivityContext.getPackageManager();
    Intent openInChooser=Intent.createChooser(sharingIntent, "Choose", pendingIntent.getIntentSender());
    List<ResolveInfo> resInfo=pm.queryIntentActivities(sharingIntent, 0);
    List<LabeledIntent> intentList=new ArrayList<>();

    Intent externalEmailIntent=new Intent(getActivityContext, ExternalEmailShareActivity.class);
            externalEmailIntent.putExtra("INBOX", "Inbox");
    intentList.add(new LabeledIntent(externalEmailIntent, "yourpackagename", "Email to", R.drawable.ic_mail_outline));

    for (int i=0; i < resInfo.size(); i++) {
        ResolveInfo ri=resInfo.get(i);
        String packageName=ri.activityInfo.packageName;
        if (packageName.contains("twitter")) {
            sharingIntent.setPackage(packageName);
        } else{
            if (packageName.contains("twitter") || packageName.contains("facebook") ||
                    packageName.contains("whatsapp") || packageName.contains("linkedin") ||
                    packageName.contains("com.google.android.apps.docs") ||
                    packageName.contains("com.google.android.gm") ||
                    packageName.contains("com.Slack")) {
                Intent shareIntent=new Intent();
                try {
                    shareIntent.setComponent(new ComponentName(packageName, ri.activityInfo.name));
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    //shareIntent.setType("text/plain/image");
                    if (packageName.contains("twitter")) {
                        shareIntent.putExtra(Intent.EXTRA_TEXT, sharedURL);
                    } else if (packageName.contains("facebook")){shareIntent.putExtra(Intent.EXTRA_TEXT, sharedURL);
                    } else if (packageName.contains("whatsapp")) {
                        shareIntent.putExtra(Intent.EXTRA_TEXT, sharedURL);
                    } else if (packageName.contains("linkedin")) {
                        shareIntent.putExtra(Intent.EXTRA_TITLE, sharedURL);
                        shareIntent.putExtra(Intent.EXTRA_TEXT, sharedURL);
                    } else if (packageName.contains("com.google.android.apps.docs")) {
                        shareIntent.putExtra(Intent.EXTRA_TEXT, sharedURL);
                    } else if (packageName.contains("com.Slack")) {
                        shareIntent.putExtra(Intent.EXTRA_TEXT, sharedURL);
                    }else if (packageName.contains("android.gm")) {
                        // If Gmail shows up twice, try removing this else-if clause and the reference to "android.gm" above
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, str_title);
                        shareIntent.setType("message/rfc822");
                        shareIntent.putExtra(Intent.EXTRA_TEXT, sharedURL);
                        Uri uri = Uri.parse(publicThumbnail);
                        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    }

                    intentList.add(new LabeledIntent(shareIntent, packageName, ri.loadLabel(pm), ri.icon));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    shareIntent=null;
                }
            }
        }

    }
    // convert intentList to array
    LabeledIntent[] extraIntents=intentList.toArray(new LabeledIntent[intentList.size()]);

    openInChooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, extraIntents);
    getActivityContext.startActivityForResult(openInChooser, REQUEST_SHARED_URL);

}