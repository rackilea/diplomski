public static void main(String[] args) {
    int width = 200, height = 300;
    //array needs to be 4 times larger than amount of pixels
    int[] pixels = new int[4*width*height];
    for (int i = 0; i < pixels.length; i++) {
        //if (i%4==0){pixels[i]=255;}//R default 0
        //if (i%4==1){pixels[i]=255;}//G default 0
        if (i%4==2){pixels[i]=255;}//B default 0 
        //Alpha
        if (i%4==3){        
            pixels[i]=(int)(255*(i/4%width)/(double)width);
        }
    }
    Image image = getImageFromArray(pixels, width, height);
    showImage(image);
}
public static void showImage(Image img){
    JFrame frame = new JFrame();
    frame.setLayout(new FlowLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel lab = new JLabel(new ImageIcon(img));
    frame.add(lab);
    frame.pack();
    frame.setVisible(true);
}
public static Image getImageFromArray(int[] pixels, int w, int h) {
    BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    WritableRaster raster = image.getRaster();
    raster.setPixels(0,0,w,h,pixels);
    return image;
}