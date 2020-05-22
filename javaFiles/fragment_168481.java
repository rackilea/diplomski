@Override
    protected void onClusterItemRendered(ClusterMarker item, final Marker marker) {
        String imageUrl = item.getImageUri();

        // here you can call your background task
        // or some other option like Glide
        // you put your icon as: 
        // marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizedBitmap));
    }