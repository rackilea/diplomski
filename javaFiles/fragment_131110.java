public void getVideoBuckets() {
    final Cursor query = this.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, this.bucketProjection, (String)null, (String[])null, "date_added");
    final ArrayList list = new ArrayList<String>(query.getCount());
    final ArrayList list2 = new ArrayList<String>(query.getCount());
    final HashSet<String> set = new HashSet<String>();
    MyLabel: {
        if (!query.moveToLast()) {
            break MyLabel;
        }
        while (!Thread.interrupted()) {
            final String string = query.getString(query.getColumnIndex(this.bucketProjection[0]));
            final String string2 = query.getString(query.getColumnIndex(this.bucketProjection[1]));
            if (string2 != null && new File(string2).exists() && !set.contains(string)) {
                list.add(string);
                list2.add(string2);
                set.add(string);
            }
            if (!query.moveToPrevious()) {
                break MyLabel;
            }
        }
        return;
    }
    query.close();
    if (list == null) {
        this.bucketNamesList = new ArrayList();
    }
    this.bucketNamesList.clear();
    this.bucketImagePathList.clear();
    this.bucketNamesList.addAll(list);
    this.bucketImagePathList.addAll(list2);
}