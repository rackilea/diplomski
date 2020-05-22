public class StretchedImage{

public static Image stretch(Image image, Insets ins, Dimension dim, int hints){
    //debugcode
    //System.out.println(dim); 

    //load image into bufferedImage
    BufferedImage bi = toBufferedImage(image, hints); 

    //create 2d bufferedImage array to hold the 9 images
    Image[][] img = new Image[3][3]; 

    //split Image into 9 subsections
    img[0][0] = bi.getSubimage(0, 0, ins.left, ins.top);
    img[0][1] = bi.getSubimage(ins.left, 0, bi.getWidth() - ins.left - ins.right, ins.top);
    img[0][2] = bi.getSubimage(bi.getWidth() - ins.right, 0, ins.right, ins.top);
    img[1][0] = bi.getSubimage(0, ins.top, ins.left, bi.getHeight() - ins.top - ins.bottom);
    img[1][1] = bi.getSubimage(ins.left, ins.top, bi.getWidth() - ins.left - ins.right, bi.getHeight() - ins.top - ins.bottom);
    img[1][2] = bi.getSubimage(bi.getWidth() - ins.right, ins.top, ins.right, bi.getHeight() - ins.top - ins.bottom);
    img[2][0] = bi.getSubimage(0, bi.getHeight() - ins.bottom, ins.left, ins.bottom);
    img[2][1] = bi.getSubimage(ins.left, bi.getHeight() - ins.bottom, bi.getWidth() - ins.left - ins.right, ins.bottom);
    img[2][2] = bi.getSubimage(bi.getWidth() - ins.right, bi.getHeight() - ins.bottom, ins.right, ins.bottom);

    //determine the width and height of the sections that will be stretched
    //only the center section will have both dimensions changed
    int w = dim.width - ins.left - ins.right;
    int h = dim.height - ins.top - ins.bottom;

    //Stretch the proper sections 
    img[0][1] = img[0][1].getScaledInstance(w, img[0][1].getHeight(null), hints);
    img[1][0] = img[1][0].getScaledInstance(img[1][0].getWidth(null), h, hints);
    img[1][1] = img[1][1].getScaledInstance(w, h, hints);
    img[1][2] = img[1][2].getScaledInstance(img[1][2].getWidth(null), h, hints);
    img[2][1] = img[2][1].getScaledInstance(w, img[2][1].getHeight(null), hints);

    //for loop is debug code
    //for(int i = 0; i < 3; i++){ 
    //  for(int j = 0; j < 3; j++){
    //      System.out.println(i + " " + j + " " + img[i][j].getWidth() + "," + img[i][j].getHeight());
    //  }
    //}

    //create a new bufferedImage to hold the final image
    BufferedImage finalImage = new BufferedImage(dim.width, dim.height, hints);
    Graphics g = finalImage.getGraphics();
    //draw the peices to the final image
    g.drawImage(img[0][0], 0, 0, null);
    g.drawImage(img[0][1], ins.left, 0, null);
    g.drawImage(img[0][2], dim.width - ins.right, 0, null);
    g.drawImage(img[1][0], 0, ins.top, null);
    g.drawImage(img[1][1], ins.left, ins.top, null);
    g.drawImage(img[1][2], dim.width - ins.right, ins.top, null);
    g.drawImage(img[2][0], 0, dim.height - ins.bottom, null);
    g.drawImage(img[2][1], ins.left, dim.height - ins.bottom, null);
    g.drawImage(img[2][2], dim.width - ins.right, dim.height - ins.bottom, null);   

    return (Image)finalImage;
}

// This method returns a buffered image with the contents of an image
public static BufferedImage toBufferedImage(Image image, int hints) {

    BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), hints);
    bi.getGraphics().drawImage(image, 0, 0, null);

    return bi;
}