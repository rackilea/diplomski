import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;

    public class FocusDemo {
       private JPanel  panel;
       private JButton button1;

       JFrame          frame = new JFrame("TempWindow");

       private FocusDemo() {
          panel = new JPanel();
          button1 = new JButton("Button");
          button1.addActionListener((ae) -> System.out.println("button pressed"));
          panel.add(button1);
          MyMouseListener ml = new MyMouseListener();
          panel.addMouseListener(ml);
          panel.addMouseMotionListener(ml);
          frame.add(panel);

       }

       public static void main(String[] args) {
          SwingUtilities.invokeLater(() -> new FocusDemo().start());
       }

       public void start() {
          frame.setLocationRelativeTo(null); // this line set the window in the
                                             // center of the screen
          frame.setPreferredSize(new Dimension(500, 500));
          frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
          frame.pack();
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);

       }

       private class MyMouseListener extends MouseAdapter {
          public void mouseEntered(MouseEvent me) {
             System.out.println("mouse entered");
          }

          public void mouseExited(MouseEvent me) {
             System.out.println("mouse exited");
          }
       }

    }