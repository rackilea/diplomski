QBCustomObject qbCustomObject = new QBCustomObject(CLASS_NAME, NOTE1_ID);
QBCustomObjectsFiles.deleteFile(qbCustomObject, AVATAR_FIELD, new QBCallbackImpl() {
    @Override
    public void onComplete(Result result) {
        if (result.isSuccess()) {
            Log.i(TAG, ">>> file deleted successfully");
        } else {
            handleErrors(result);
        }
    }
});