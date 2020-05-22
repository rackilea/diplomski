public void displayImage() {
    //if image is not loaded into memory
    if (image == null) {
        //then load it, go to disk only once
        image = new RealImage(filename);
    }
    //now it is in memory, display the real image
    image.displayImage();
}