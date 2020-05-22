QBCustomObject qbCustomObject = new QBCustomObject(CLASS_NAME, NOTE1_ID);
QBCustomObjectsFiles.uploadFile(file1, qbCustomObject, AVATAR_FIELD, new QBCallbackImpl() {
    @Override
    public void onComplete(Result result) {
        if (result.isSuccess()) {
            QBCustomObjectFileField customObjectFileField = ((QBCOFileUploadResult) result).getCustomObjectFileField();
            Log.i(TAG, ">>>upload response:" + customObjectFileField.getFileName() + " " + customObjectFileField.getFileId() + " " +
                                customObjectFileField.getContentType());
        } else {
            handleErrors(result);
        }
   }
});