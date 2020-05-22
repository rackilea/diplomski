public static void main(String... args) throws IOException {
    int w = 40, h = 40, divs = 5;

    BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
    WritableRaster raster = bi.getRaster();

    for(int i=0; i<w; i++)
        for(int j=0; j<h; j++)
            raster.setSample(i,j,0,128+(int)(127*Math.sin(Math.PI*i/w*divs)*Math.sin(Math.PI*j/h*divs)));

    ImageIO.write(bi, "jpg", new File("C:\\Users\\user\\Desktop\\test.jpg"));
}