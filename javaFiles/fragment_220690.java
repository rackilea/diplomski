// unchecked by default, unless proven checked below
imagesViewHolder.toggleFavorite.setChecked(false);
for (Image image: database.getAllData()) {
    if (image.getUrl().equals(currentImage.getUrl())) {
        imagesViewHolder.toggleFavorite.setChecked(true);
        break;
    }
}