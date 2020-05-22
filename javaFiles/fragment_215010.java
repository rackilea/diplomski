QBCustomObject qbCustomObject = new QBCustomObject(CLASS_NAME, NOTE1_ID);
QBCustomObjectsFiles.downloadFile(qbCustomObject, AVATAR_FIELD, new QBCallbackImpl() {
    @Override
    public void onComplete(Result result) {
        QBFileDownloadResult downloadResult = (QBFileDownloadResult) result;
        if (result.isSuccess()) {
            byte[] content = downloadResult.getContent();       // that's downloaded file content
            InputStream is = downloadResult.getContentStream(); // that's downloaded file content
            Log.i(TAG, ">>> file downloaded successfully" + getContentFromFile(is));
            if(is!=null){
                try{
                    is.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
       } else {
           handleErrors(result);
       }
    }
});