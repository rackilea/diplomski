List<ResolveInfo> resInfo = packageManager.queryIntentActivities(intent, flags);
if(resInfo !=null && resInfo.size()>0) {
    //Display the activity list that can handle this file format
} else {
    //Handle this file by your own code or display error message
}