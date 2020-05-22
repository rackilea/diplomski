@Override
    protected void onPostExecute(Object o) {
        // Dont check here you dont have image then you are downloading it.its Already checked?
        // rather then check bitmap you are going to save should not be null
        if (bitmap != null) {
            view.setImageBitmap(bitmap);
            ImageStorage.saveToSdCard(bitmap, imagename_);
        }
    }