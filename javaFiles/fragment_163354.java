import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ImageColumnTest2 {
   public static final String IMAGE_SHEET_PATH = "http://speckycdn.sdm.netdna-cdn.com/"
         + "wp-content/uploads/2010/08/flag_icons_04.jpg";
   public static final String[] COUNTRIES = {
      "Denmark", "China", "Chile", "Canada", "Belgium", "Austria",
      "Argentina", "France", "Malaysina", "Lebanon", "Korea", "Japan",
      "Italy", "Ireland", "India", "Hong Kong", "Greece", "Germany"
   };
   public static final int COLS = 6;
   public static final int ROWS = 3;
   private static final String[] COL_NAMES = {"Country", "Flag"};

   private JTable table = new JTable();
   private JScrollPane mainPane = new JScrollPane(table);

   public ImageColumnTest2() throws IOException {
      DefaultTableModel model = new DefaultTableModel(COL_NAMES, 0) {
         @Override
         public Class<?> getColumnClass(int column) {
            if (getRowCount() > 0) {
               Object value = getValueAt(0, column);
               if (value != null) {
                  return getValueAt(0, column).getClass();
               }
            }

            return super.getColumnClass(column);
         }
      };
      URL url = new URL(IMAGE_SHEET_PATH);
      BufferedImage img = ImageIO.read(url);
      int x1 = 15;  // sorry about the magic numbers
      img = img.getSubimage(x1, 0, img.getWidth() - 2 * x1, img.getHeight());

      int y1 = 20 ;  // ditto!
      int w = img.getWidth() / COLS;
      int h = img.getHeight() / ROWS;
      for (int row = 0; row < ROWS; row++) {
         int y = (row * img.getHeight()) / ROWS;
         for (int col = 0; col < COLS; col++) {
            int x = (col * img.getWidth()) / COLS;
            BufferedImage subImg = img.getSubimage(x, y, w, h);

            subImg = subImg.getSubimage(x1, 0, subImg.getWidth() - 2 * x1, subImg.getHeight() - y1);

            ImageIcon icon = new ImageIcon(subImg);
            String country = COUNTRIES[col + row * COLS];
            Object[] rowData = {country, icon};
            model.addRow(rowData);
         }
      }


      table.setModel(model);
      table.setRowHeight(((ImageIcon)model.getValueAt(0, 1)).getIconHeight());
   }

   public JComponent getMainComponent() {
      return mainPane;
   }

   private static void createAndShowGui() {
      ImageColumnTest2 imgColumnTest = null;
      try {
         imgColumnTest = new ImageColumnTest2();
      } catch (MalformedURLException e) {
         e.printStackTrace();
         System.exit(-1);
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }

      JFrame frame = new JFrame("ImageColumnTest");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(imgColumnTest.getMainComponent());
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}