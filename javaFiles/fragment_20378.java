wv.setPictureListener(new WebView.PictureListener() {
    @Override
    public void newPicture(WebView view, Picture arg1) {
        alert.show();
    }
}