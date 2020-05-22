import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class surface extends JPanel {

   private List<Line2D> lineList = new ArrayList<>();

   public surface() {
      int delay = 1000; // milliseconds
      // Somewhere there is that problem ..

      ActionListener taskPerformer = new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            doDrawing();
         }
      };
      new Timer(delay, taskPerformer).start();
   }

   private void doDrawing() {

      // souradnice stredu ciferniku
      final int sx = 250;
      final int sy = 250;

      // inicializace promennych
      int uhel = 0;
      int delka = 150;
      int xHodina, xMinuta, xSekunda, yHodina, yMinuta, ySekunda;

      // získání aktuálního času
      int HOUR = Calendar.getInstance().get(Calendar.HOUR);
      int MINUTE = Calendar.getInstance().get(Calendar.MINUTE) + 1;
      int SECOND = Calendar.getInstance().get(Calendar.SECOND) + 1;

      // výpočet jednotlivých úhlů pro jednotlivé ručičky a jejich vykreslení
      xSekunda = (int) ((int) sx + Math.round(Math
            .sin((6 * SECOND * Math.PI / 180)) * delka));
      ySekunda = (int) ((int) sy - Math.round(Math
            .cos((6 * SECOND * Math.PI / 180)) * delka));

      Line2D line = new Line2D.Double(sx, sy, xSekunda, ySekunda);
      lineList.add(line);
      repaint();

      // info
      System.out.print(" " + (6 * SECOND) + "  " + HOUR + "  " + MINUTE + "  "
            + SECOND + "     " + xSekunda + " " + ySekunda + "\n");
   }

   @Override
   public void paintComponent(final Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      g2d.setColor(Color.black);

      for (Line2D line2d : lineList) {
         g2d.draw(line2d);
      }

   }
}