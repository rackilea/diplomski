private class GetFileListTask extends AsyncTask<Void, Void, Void> {
    // The list of objects we find in the S3 bucket
    private List<S3ObjectSummary> s3ObjList;
    // A dialog to let the user know we are retrieving the files
    private ProgressDialog dialog;

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(DownloadSelectionActivity.this,
                getString(R.string.refreshing),
                getString(R.string.please_wait));
    }

    @Override
    protected Void doInBackground(Void... inputs) {
        // Queries files in the bucket from S3.
        s3ObjList = s3.listObjects(Constants.BUCKET_NAME).getObjectSummaries();
        transferRecordMaps.clear();
        for (S3ObjectSummary summary : s3ObjList) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("key", summary.getKey());
            transferRecordMaps.add(map);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        dialog.dismiss();
        simpleAdapter.notifyDataSetChanged();
    }
}