List<NearbyPlaces.Result.Photos> photos = placeModels.get(i).getPhotos();
if(photos != null && !photos.isEmpty()) {
    String photoReference = photos.get(0).getPhotoReference();

    // Use photoReference here
}