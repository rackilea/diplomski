public class TrimWhite {
    private BufferedImage img;

    public TrimWhite(File input) {
        try {
            img = ImageIO.read(input);
        } catch (IOException e) {
            throw new RuntimeException( "Problem reading image", e );
        }
    }

    public void trim() {
        int width  = getTrimmedWidth();
        int height = getTrimmedHeight();

        BufferedImage newImg = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = newImg.createGraphics();
        g.drawImage( img, 0, 0, null );
        img = newImg;
    }

    public void write(File f) {
        try {
            ImageIO.write(img, "bmp", f);
        } catch (IOException e) {
            throw new RuntimeException( "Problem writing image", e );
        }
    }

    private int getTrimmedWidth() {
        int height       = this.img.getHeight();
        int width        = this.img.getWidth();
        int trimmedWidth = 0;

        for(int i = 0; i < height; i++) {
            for(int j = width - 1; j >= 0; j--) {
                if(img.getRGB(j, i) != Color.WHITE.getRGB() &&
                        j > trimmedWidth) {
                    trimmedWidth = j;
                    break;
                }
            }
        }

        return trimmedWidth;
    }

    private int getTrimmedHeight() {
        int width         = this.img.getWidth();
        int height        = this.img.getHeight();
        int trimmedHeight = 0;

        for(int i = 0; i < width; i++) {
            for(int j = height - 1; j >= 0; j--) {
                if(img.getRGB(i, j) != Color.WHITE.getRGB() &&
                        j > trimmedHeight) {
                    trimmedHeight = j;
                    break;
                }
            }
        }

        return trimmedHeight;
    }

    public static void main(String[] args) {
        TrimWhite trim = new TrimWhite(new File("...\\someInput.bmp"));
        trim.trim();
        trim.write(new File("...\\someOutput.bmp"));
    }
}