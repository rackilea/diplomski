public final class Pixel {

    private int value;

    public Pixel (int rgb) {
        this.value = value;
    }

    public int getRed() {
        return (this.value >> 16) & 0xFF;
    }

    public int getGreen() {
        return (this.value >>  8) & 0xFF;
    }

    public int getBlue() {
        return (this.value >>  0) & 0xFF;
    }

    public void setRed(final int r) {
        this.value = (this.value & 0xFF00FFFF) | ((r & 0xFF) << 16);
    }

    public void setGreen(final int g) {
        this.value = (this.value & 0xFFFF00FF) | ((g & 0xFF) <<  8);
    }

    public void setBlue(final int b) {
        this.value = (this.value & 0xFFFFFF00) | ((b & 0xFF) <<  0);
    }

    @Override
    public String toString() {
        return String.format("rgb = (%3d, %3d, %3d)",
                             this.getRed(),
                             this.getGreen(),
                             this.getBlue());
    }

    public static void main(String[] args) {
        final Pixel pixel = new Pixel(0);
        System.out.println(pixel);
        pixel.setRed(42);
        pixel.setGreen(18);
        pixel.setBlue(225);
        System.out.println(pixel);
        pixel.setRed(-1);
        pixel.setGreen(500);
        pixel.setBlue(1000);
        System.out.println(pixel);
    }
}