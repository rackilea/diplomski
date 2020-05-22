private void beginUpload(String filePath) {
    if (filePath == null) {
        Toast.makeText(this, "Could not find the filepath of the selected file",
                Toast.LENGTH_LONG).show();
        return;
    }
    File file = new File(filePath);
    TransferObserver observer = transferUtility.upload(Constants.BUCKET_NAME, file.getName(),
            file);
    observers.add(observer);
    HashMap<String, Object> map = new HashMap<String, Object>();
    Util.fillMap(map, observer, false);
    transferRecordMaps.add(map);
    observer.setTransferListener(new UploadListener());
    simpleAdapter.notifyDataSetChanged();
}