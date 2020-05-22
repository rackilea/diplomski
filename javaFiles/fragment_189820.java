class tmpPanel extends JPanel {

    private File pngFile;
    private int boldSize = 1;
    boolean nightMode = true;
    private static final int arr[][] = new int[1377][886]; //width, hight of image

    public tmpPanel() {
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    ++boldSize;
                    repaint();
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    --boldSize;
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    public void setPngFile(File pngFile) {
        this.pngFile = pngFile;
    }

    private void dilate(int[][] image, int k) {
        image = manhattan(image);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                image[i][j] = (image[i][j] <= k) ? 1 : 0;
            }
        }
    }

    /**
     * Converts an image to a binary one based on given threshold
     *
     * @param image the image to convert. Remains untouched.
     * @param threshold the threshold in [0,255]
     * @return a new BufferedImage instance of TYPE_BYTE_GRAY with only 0'S and
     * 255's
     */
    public BufferedImage thresholdImage(BufferedImage image, int threshold) {
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        result.getGraphics().drawImage(image, 0, 0, null);
        WritableRaster raster = result.getRaster();
        int[] pixels = new int[image.getWidth()];
        for (int y = 0; y < image.getHeight(); y++) {
            raster.getPixels(0, y, image.getWidth(), 1, pixels);
            for (int i = 0; i < pixels.length; i++) {
                if (pixels[i] < threshold) {
                    pixels[i] = 1;
                } else {
                    pixels[i] = 0;
                }
            }
            raster.setPixels(0, y, image.getWidth(), 1, pixels);
        }
        return result;
    }

    private int[][] manhattan(int[][] image) {
        // traverse from top left to bottom right
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                if (image[i][j] == 1) {
                    // first pass and pixel was on, it gets a zero
                    image[i][j] = 0;
                } else {
                // pixel was off
                    // It is at most the sum of the lengths of the array
                    // away from a pixel that is on
                    image[i][j] = image.length + image[i].length;
                    // or one more than the pixel to the north
                    if (i > 0) {
                        image[i][j] = Math.min(image[i][j], image[i - 1][j] + 1);
                    }
                    // or one more than the pixel to the west
                    if (j > 0) {
                        image[i][j] = Math.min(image[i][j], image[i][j - 1] + 1);
                    }
                }
            }
        }
        // traverse from bottom right to top left
        for (int i = image.length - 1; i >= 0; i--) {
            for (int j = image[i].length - 1; j >= 0; j--) {
            // either what we had on the first pass
                // or one more than the pixel to the south
                if (i + 1 < image.length) {
                    image[i][j] = Math.min(image[i][j], image[i + 1][j] + 1);
                }
                // or one more than the pixel to the east
                if (j + 1 < image[i].length) {
                    image[i][j] = Math.min(image[i][j], image[i][j + 1] + 1);
                }
            }
        }
        return image;
    }

    @Override
    public void paint(Graphics g) {
        try {
            super.paint(g); //To change body of generated methods, choose Tools | Templates.
            BufferedImage image = ImageIO.read(pngFile);
            BufferedImage res = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
            Graphics2D d = (Graphics2D) res.createGraphics();
            d.setColor(Color.WHITE);
            d.fillRect(0, 0, res.getWidth(), res.getHeight());
            d.drawImage(image, 0, 0, res.getWidth(), res.getHeight(), null);
            res = thresholdImage(res, 128);
            WritableRaster raster = res.getRaster();
            if (boldSize > 0) {
                for (int i = 0; i < res.getHeight(); ++i)
                    raster.getPixels(0, i, res.getWidth(), 1, arr[i]);
                dilate(arr, boldSize);
                for (int i = 0; i < res.getHeight(); ++i) {
                    for (int j = 0; j < res.getWidth(); ++j)
                        if (arr[i][j] == 1)
                            arr[i][j] = nightMode ? 255 : 0;
                        else
                            arr[i][j] = nightMode ? 0 : 255;
                    raster.setPixels(0, i, res.getWidth(), 1, arr[i]);
                }
            }
            g.drawImage(res, 0, 0, getWidth(), getHeight(), null);
            //for (int i = 0; i < boldSize; ++i)
                //g.drawImage(image, 0, i, getWidth(), getHeight(), null);
        } catch (IOException ex) {
            Logger.getLogger(tmpPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}