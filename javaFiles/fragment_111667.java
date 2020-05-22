new PixelReader() {
    @Override
    public int getArgb(int x, int y) {
        PlatformImage pimg = platformImage.get();
        return pimg.getArgb(x, y);
    }
}