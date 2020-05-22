public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        BufferedImage img1 = null;
        BufferedImage img2 = null;

        try
        {
            URL url1 = new URL("http://rosettacode.org/mw/images/3/3c/Lenna50.jpg");
            URL url2 = new URL("http://rosettacode.org/mw/images/b/b6/Lenna100.jpg");

            URLConnection conn1 = url1.openConnection();
            conn1.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            InputStream in1 = conn1.getInputStream();

            URLConnection conn2 = url2.openConnection();
            conn2.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            InputStream in2 = conn2.getInputStream();


            img1 = ImageIO.read(in1);
            img2 = ImageIO.read(in2);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        int width1 = img1.getWidth(null);
        int width2 = img2.getWidth(null);
        int height1 = img1.getHeight(null);
        int height2 = img2.getHeight(null);
        if ((width1 != width2) || (height1 != height2))
        {
            System.err.println("Error: Images dimensions mismatch");
            System.exit(1);
        }
        long diff = 0;
        for (int y = 0; y < height1; y++)
        {
            for (int x = 0; x < width1; x++)
            {
                int rgb1 = img1.getRGB(x, y);
                int rgb2 = img2.getRGB(x, y);
                int r1 = (rgb1 >> 16) & 0xff;
                int g1 = (rgb1 >> 8) & 0xff;
                int b1 = (rgb1) & 0xff;
                int r2 = (rgb2 >> 16) & 0xff;
                int g2 = (rgb2 >> 8) & 0xff;
                int b2 = (rgb2) & 0xff;
                diff += Math.abs(r1 - r2);
                diff += Math.abs(g1 - g2);
                diff += Math.abs(b1 - b2);
            }
        }
        double n = width1 * height1 * 3;
        double p = diff / n / 255.0;
        System.out.println("diff percent: " + (p * 100.0));
    }