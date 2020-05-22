imageLoader.loadImage(url, new SimpleImageLoadingListener(){

                    @Override
                    public void onLoadingComplete(String imageUri, View view,
                            Bitmap loadedImage) {
                    super.onLoadingComplete(imageUri, view, loadedImage);

                        //write your code here to use loadedImage
                    }

                });