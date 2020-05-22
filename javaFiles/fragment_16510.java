protected void onPostExecute(Integer newImageId) {
    ImageView cardImageView = (ImageView) findViewById(R.id.cardImage);
    cardImageView.invalidate();
    cardImageView.setImageResource(cardGallery[newImageId]);
    imageId = newImageId;
}