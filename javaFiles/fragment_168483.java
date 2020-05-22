public void updateMarker(final String id, String imgUrl) {
        if (markers.size() > 0) {
            if (iconImage != null) {
                Glide.with(mContext.getApplicationContext())
                        .load(imgUrl)
                        .apply(new RequestOptions()
                                .optionalCircleCrop()
                                .placeholder(R.mipmap.default_event_cover_rounded)
                                .error(R.mipmap.default_event_cover_rounded)
                                .diskCacheStrategy(DiskCacheStrategy.ALL))
                        .into(new SimpleTarget<Drawable>() {
                            @Override
                            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                                iconImage.setImageDrawable(resource);
                                Bitmap icon = iconGenerator.makeIcon();
                                try {
                                    markers.get(id).setIcon(BitmapDescriptorFactory.fromBitmap(icon));
                                } catch (Exception e) {
                                    Log.d("TAG_SNAP", "onResourceReady: " + e.getMessage() + markers.get(id).getTitle());
                                }
                            }
                        });
            }
        }