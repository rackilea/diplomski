public class Part extends JPanel {
    private Image src;

    public Part(Image src) {
        this.src = src;
    }

    public Image create(int xPos, int yPos, int width, int height) {
        ImageFilter cropImagefilter = new CropImageFilter(xPos, yPos, width, height); //see constructor detail
        FilteredImageSource filteredImageSource = new FilteredImageSource(this.src.getSource(), cropImagefilter)
        Image part = createImage(filteredImageSource);
        return part;
    }
}