import java.awt.Color;
       import java.awt.Graphics;
      import java.awt.image.BufferedImage;
      import java.awt.image.RescaleOp;
     import java.io.IOException;
     import javax.media.jai.JAI;
     import javax.media.jai.PlanarImage;
        import javax.swing.*;

    public class FinalHistogram extends JPanel {

   int[] bins = new int[256];
  FinalHistogram(int[] pbins) {
    bins = pbins;
    repaint();
   }

 @Override
 protected void paintComponent(Graphics g) {
    //g.drawLine();

    for (int i = 0; i < 256; i++) {

        System.out.println("bin[" + i + "]===" + bins[i]);
        g.drawLine(200 + i, 300, 200 + i, 300 - (bins[i])/1000);
        //g.drawLine(200 + i, 200, 200 + i, 200-(bins[i])/1500);

        //  System.out.println("bin["+i+"]==="+bins[i]);
     }

   }


  public static void main(String[] args) throws IOException {
    JFrame frame = new JFrame();
    frame.setSize(500, 500);
    int[] pbins = new int[256];
    int[] sbins = new int[256];
    PlanarImage image = JAI.create("fileload", "image12.tiff");
    BufferedImage bi = image.getAsBufferedImage();    
    System.out.println("tipe is          " + bi.getType());
    int[] pixel = new int[3];

    int k = 0;
    Color c = new Color(k);
    Double d = 0.0;
    Double d1;
    for (int x = 0; x < bi.getWidth(); x++) {
        for (int y = 0; y < bi.getHeight(); y++) {
            pixel = bi.getRaster().getPixel(x, y, new int[3]);
          d=(0.2125*pixel[0])+(0.7154*pixel[1])+(0.072*pixel[2]);
              k=(int) (d/256);

            sbins[k]++;
        }

     }
     System.out.println("copleted" + d + "--" + k);
     JTabbedPane jtp=new JTabbedPane();
     ImageIcon im= new ImageIcon(bi);
      //jtp.add("New image", new JLabel((im)));
        jtp.addTab("Histogram",new FinalHistogram(sbins));
        frame.add(jtp);
     frame.setVisible(true);
     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }
 }