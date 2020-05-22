String imageName = imagePath.replace("/storage/emulated/0/DCIM/Camera/", "");

MarkerOptions options = new MarkerOptions()
    .position(imageLocation)
    .title(imageName)
    .icon(BitmapDescriptorFactory.fromBitmap(icon));
Marker marker=    mMap.addMarker(options);
 //set your image path as tag of marger
 marker.setTag(imageName);

//map marker click listener
 googleMap.setOnMarkerClickListener(marker -> {
        if (marker.getTag() != null) {
            String imagePath = (String) marker.getTag();
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse(imagePath), "image/*");
            startActivity(intent);
        }
        return false;
    });