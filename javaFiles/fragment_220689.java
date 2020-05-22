for (Image image: database.getAllData()) {
    if (image.getUrl().equals(currentImage.getUrl())) {
        imagesViewHolder.toggleFavorite.setChecked(true);
        break;
    }
}