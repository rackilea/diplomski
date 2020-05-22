@Override
    protected void onClusterItemRendered(EventMarker clusterItem, final Marker marker) {
        String imageUrl = clusterItem.getImageUri();

        if (imageView != null && imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(mContext.getApplicationContext())
                    .load(imageUrl)
                    .apply(new RequestOptions()
                            .optionalCircleCrop()
                            .placeholder(R.mipmap.default_event_cover_rounded)
                            .error(R.mipmap.default_event_cover_rounded)
                            .diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(new SimpleTarget<Drawable>() {
                        @Override
                        public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            imageView.setImageDrawable(resource);
                            Bitmap icon = iconGenerator.makeIcon();
                            try {
                                marker.setIcon(BitmapDescriptorFactory.fromBitmap(icon));
                            } catch (Exception e) {
                                Log.d("TAG", "onResourceReady: " + e.getMessage());
                            }
                        }
                    });
        }
    }