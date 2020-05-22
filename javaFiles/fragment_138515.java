public class TextToGraphics {

public static void main(String[] args) {
    try {
        String storeData = "";
        String data = "";
        File f = new File("/home/vipul/Desktop/123.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));

        while ((data = br.readLine()) != null) {
            storeData =storeData + data +System.lineSeparator();
        }
        String [] sArr = storeData.split("\n");
        int longest =0;
        int lines = 0;
        for (String s : sArr){       //find the longest string
            if(s.length()>longest){
            longest = s.length();
            }
            lines++;              //count lines
        }

        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Arial", Font.PLAIN, 24);
        g2d.setFont(font);

        FontMetrics fm = g2d.getFontMetrics();

        int width = fm.stringWidth(storeData);
        int height = fm.getHeight();
        g2d.dispose();

        img = new BufferedImage(longest*font.getSize(), lines*font.getSize(), BufferedImage.TYPE_3BYTE_BGR); // set width and height in accordance with longest string and number of lines
        g2d = img.createGraphics();
        g2d.setPaint ( new Color ( 255, 255, 255 ) );
       g2d.fillRect ( 0, 0, img.getWidth(), img.getHeight() );
        System.out.println(img.getWidth()+" "+img.getHeight());
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();


        g2d.setColor(Color.BLACK);
        int i = 0;
        for(String s : storeData.split("\n")){            
            g2d.drawString(s, 0, fm.getAscent()+i); // call drawString for each line
            i+=10;
        }
        g2d.dispose();

        ImageIO.write(img, "bmp", new File("/home/vipul/Desktop/123.bmp"));

    } catch (Exception ex) {
        ex.printStackTrace();
    }

}