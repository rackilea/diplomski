String uri = "http://192.168.2.8:3000" + articlesArray.getJSONObject(i).getString("icon");

            ImageLoader imageLoader = ImageLoader.getInstance();
            ImageSize targetSize = new ImageSize(37, 32);
            ImageAware imageAware = new NonViewAware(targetSize, ViewScaleType.CROP);
            imageLoader.displayImage(uri,imageAware, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String s, View view) {
                    Log.e("tag", "onLoadingStarted");
                }

                @Override
                public void onLoadingFailed(String s, View view, FailReason failReason) {
                    Log.e("tag", "onLoadingFailed");
                }

                @Override
                public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                    Log.e("tag", "onLoadingComplete");
                    marker.setIcon(BitmapDescriptorFactory.fromBitmap(bitmap));
                }

                @Override
                public void onLoadingCancelled(String s, View view) {
                    Log.e("tag", "onLoadingCancelled");
                }
            });