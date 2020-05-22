CountingMultipartEntity entity = new CountingMultipartEntity(new ProgressListener() {
    @Override
    public void transferred(long num) {
        // update the progress bar or whatever else you might want to do
    }
});