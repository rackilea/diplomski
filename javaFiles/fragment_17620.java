new Thread(new GetBitmapTask("", new GetBitmapTask.Callback() {
    @Override public void onFinish(Bitmap bitmap) {
        //here is your bitmap
    }

    @Override public void onError(Throwable t) {
        //here you have to handle error
    }
})).start();