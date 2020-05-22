import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class RobotVsPrintAll extends JPanel {
   private static final int WORDS = 400;
   private JTextArea textArea = new JTextArea(20, 40);
   private JScrollPane scrollPane = new JScrollPane(textArea);
   private Random random = new Random();

   public RobotVsPrintAll() {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < WORDS; i++) {
         int wordLength = random.nextInt(4) + 4;
         for (int j = 0; j < wordLength; j++) {
            char myChar = (char) (random.nextInt('z' - 'a' + 1) + 'a');
            sb.append(myChar);
         }
         sb.append(" ");
      }
      textArea.setText(sb.toString());

      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

      JButton robot1Btn = new JButton(new Robot1Action("Robot 1"));
      JButton robot2Btn = new JButton(new Robot2Action("Robot 2"));
      JButton printAllBtn = new JButton(new PrintAllAction("Print All"));

      JPanel btnPanel = new JPanel();
      btnPanel.add(robot1Btn);
      btnPanel.add(robot2Btn);
      btnPanel.add(printAllBtn);

      setLayout(new BorderLayout());
      add(scrollPane, BorderLayout.CENTER);
      add(btnPanel, BorderLayout.PAGE_END);
   }

   private void displayImg(BufferedImage img) {
      ImageIcon icon = new ImageIcon(img);
      JOptionPane.showMessageDialog(this, icon, "Display Image", 
            JOptionPane.PLAIN_MESSAGE);
   }

   private class Robot1Action extends AbstractAction {
      public Robot1Action(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         try {
            Component comp = scrollPane.getViewport();
            Point p = comp.getLocationOnScreen();
            Dimension d = comp.getSize();

            Robot robot = new Robot();

            Rectangle screenRect = new Rectangle(p.x, p.y, d.width, d.height);
            BufferedImage img = robot.createScreenCapture(screenRect);
            displayImg(img);

         } catch (AWTException e1) {
            e1.printStackTrace();
         }

      }

   }

   private class Robot2Action extends AbstractAction {
      public Robot2Action(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         try {
            Component comp = textArea;
            Point p = comp.getLocationOnScreen();
            Dimension d = comp.getSize();

            Robot robot = new Robot();

            Rectangle screenRect = new Rectangle(p.x, p.y, d.width, d.height);
            BufferedImage img = robot.createScreenCapture(screenRect);
            displayImg(img);

         } catch (AWTException e1) {
            e1.printStackTrace();
         }

      }

   }

   private class PrintAllAction extends AbstractAction {
      public PrintAllAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      public void actionPerformed(ActionEvent e) {
         Dimension d = textArea.getSize();
         BufferedImage img = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB);
         Graphics g = img.getGraphics();
         textArea.printAll(g);
         g.dispose();
         displayImg(img);
      }
   }

   private static void createAndShowGui() {
      RobotVsPrintAll mainPanel = new RobotVsPrintAll();

      JFrame frame = new JFrame("Robot Vs PrintAll");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
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