public void switchImageAlpha() {
    if (imageOne.getImageAlpha() == halfAlpha) {
        imageOne.setImageAlpha(opaque);
        imageTwo.setImageAlpha(halfAlpha);
    } else {
        imageOne.setImageAlpha(halfAlpha);
        imageTwo.setImageAlpha(opaque);
    }
}