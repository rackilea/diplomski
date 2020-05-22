import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainDisplayPanel extends JPanel {
   private static final int RESIZABLE_COUNT = 40;
   private JButton deleteButton;
   private Resizable current;
   private Resizable resizer;
   private List<Resizable> resizableList = new ArrayList<Resizable>();

   public MainDisplayPanel(LayoutManager layout) {
      super(layout);

      deleteButton = new JButton("Delete");
      deleteButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            deleteButtonActionPerformed(e);
         }
      });
      this.addMouseListener(new MyMouseAdapter());
      this.add(deleteButton);

      for (int i = 0; i < RESIZABLE_COUNT; i++) {
         addResizer();
      }
   }

   private void deleteButtonActionPerformed(ActionEvent e) {
      if (current != null) {
         this.remove(current);
         resizableList.remove(current);
         current = null;
         this.revalidate();
         this.repaint();
      }
   }

   public void addResizer() {
      resizer = new Resizable();
      this.add(resizer);
      resizableList.add(resizer);
      this.revalidate();
      this.repaint();
   }

   private class MyMouseAdapter extends MouseAdapter {

      @Override
      public void mousePressed(MouseEvent e) {
         current = null;
         Component c = getComponentAt(e.getPoint());
         for (Resizable resizable : resizableList) {
            if (resizable == c) {
               current = resizable;
               resizable.setFill(true);
            } else {
               resizable.setFill(false);
            }
         }
      }
   }

   public static void main(String[] args) {
      JFrame jframe = new JFrame();
      // !! jframe.add(new MainDisplayPanel(null));
      jframe.add(new MainDisplayPanel(new FlowLayout()));
      jframe.setSize(new Dimension(600, 400));
      jframe.setVisible(true);
      jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

}

@SuppressWarnings("serial")
class Resizable extends JPanel {

   private static final int RESIZE_WIDTH = 50;
   private static final int RESIZE_HEIGHT = 40;
   private static final int THICKNESS = 5;
   private static final Color FILL_COLOR = Color.pink;

   public Resizable() {
      Random rand = new Random();

      // different color border so we can see that it was the clicked one that was deleted.
      Color color = new Color(
               rand.nextInt(255), 
               rand.nextInt(255), 
               rand.nextInt(255));
      setBorder(BorderFactory.createLineBorder(color, THICKNESS));
   }

   @Override // so we can see it
   public Dimension getPreferredSize() {
      return new Dimension(RESIZE_WIDTH, RESIZE_HEIGHT);
   }

   public void setFill(boolean fill) {
      Color fillColor = fill ? FILL_COLOR : null;
      setBackground(fillColor);
      repaint();
   }

}