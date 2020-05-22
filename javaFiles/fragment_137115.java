public void showImage() {
    try {
        Image image = new Image("resources/img/akonolingaMap.jpg");
        imageView.setImage(image);
        imageView.setCache(true);
    } catch (Exception e) {
        printStackTrace();
    }
}