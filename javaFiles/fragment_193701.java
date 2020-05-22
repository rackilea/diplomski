//Getting thread Id
ContentResolver mContentResolver = context.getContentResolver();
Uri uriSmsURI1 = Uri.withAppendedPath(Telephony.MmsSms.CONTENT_FILTER_BYPHONE_URI, address);
String[] projection1 = {this.threadId};
Cursor c1 = dbService.query(mContentResolver, uriSmsURI1, projection1, null, null, null);
if(c1.getCount()==0) {
    log.error(methodName, "Got count: "+c1.getCount()+" While looking for ThreadID");
        return null;
}
String threadId = null;
while(c1.moveToNext()){
    threadId = c1.getString(c1.getColumnIndexOrThrow(this.threadId));
}
c1.close();