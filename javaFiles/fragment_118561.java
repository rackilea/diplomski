import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class HandlerTester extends JPanel {
   public HandlerTester() {
      Handler handler = new Handler();
      final MyPanel myPanel = new MyPanel();
      myPanel.addMouseListener(handler);
      myPanel.addMouseMotionListener(handler);

      final StatusPanel statusPanel = new StatusPanel();

      myPanel.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent pcEvt) {
            if (MyPanel.MOUSE_PRESSED.equals(pcEvt.getPropertyName())) {
               statusPanel.setMousePressed(((Boolean)pcEvt.getNewValue()).booleanValue());
            }
         }
      });

      setLayout(new BorderLayout());
      add(myPanel, BorderLayout.CENTER);
      add(statusPanel, BorderLayout.PAGE_END);
   }

   private static void createAndShowGUI() {
      HandlerTester handlerTester = new HandlerTester();

      JFrame frame = new JFrame("HandlerTester");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(handlerTester);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}

class Handler extends MouseAdapter {
   @Override
   public void mousePressed(MouseEvent mEvt) {
      Object src = mEvt.getSource();
      if (src instanceof MyPanel) {
         MyPanel myPanel = (MyPanel) src;
         myPanel.setMousePressed(true);         
      }
   }

   @Override
   public void mouseReleased(MouseEvent mEvt) {
      Object src = mEvt.getSource();
      if (src instanceof MyPanel) {
         MyPanel myPanel = (MyPanel) src;
         myPanel.setMousePressed(false);         
      }
   }
}

@SuppressWarnings("serial")
class MyPanel extends JPanel {
   public static final String MOUSE_PRESSED = "mouse pressed";
   private static final int PREF_W = 600;
   private static final int PREF_H = 400;
   private boolean mousePressed = false;

   public boolean isMousePressed() {
      return mousePressed;
   }

   public void setMousePressed(boolean mousePressed) {
      boolean oldValue = this.mousePressed;
      boolean newValue = mousePressed;
      this.mousePressed = mousePressed;
      firePropertyChange(MOUSE_PRESSED, oldValue, newValue);
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
}

@SuppressWarnings("serial")
class StatusPanel extends JPanel {
   private static final String MOUSE_PRESSED = "Mouse Pressed";
   private static final String MOUSE_NOT_PRESSED = "Mouse Not Pressed";
   private JLabel label = new JLabel(MOUSE_NOT_PRESSED);

   public StatusPanel() {
      setLayout(new FlowLayout(FlowLayout.LEADING));
      add(label);
      setBorder(BorderFactory.createEtchedBorder());
   }

   public void setMousePressed(boolean mousePressed) {
      String text = mousePressed ? MOUSE_PRESSED : MOUSE_NOT_PRESSED;
      label.setText(text);
   }
}