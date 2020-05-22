import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class TestUndecoratedKeyListener {
   protected static final int PREF_W = 400;
   protected static final int PREF_H = PREF_W;

   private static void createAndShowGui() {
      final JFrame frame = new JFrame("TestUndecoratedKeyListener");

      final JPanel mainPanel = new JPanel() {
         @Override
         public Dimension getPreferredSize() {
            return new Dimension(PREF_W, PREF_H);
         }
      };

      JToggleButton toggleButton = new JToggleButton("Full Screen");
      toggleButton.setFocusable(false);
      toggleButton.setMnemonic(KeyEvent.VK_F);
      toggleButton.addItemListener(new ItemListener() {

         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
               frame.dispose();
               frame.setUndecorated(true);
               frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
               frame.setVisible(true);
            } else {
               frame.dispose();
               frame.setUndecorated(false);
               frame.setExtendedState(JFrame.NORMAL);
               frame.pack();
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
            }
         }
      });
      mainPanel.add(toggleButton);
      final JLabel keyListenerLabel = new JLabel();
      final JLabel keyBindingLabel = new JLabel();

      mainPanel.add(new JLabel("Press Right or Left Arrow Key To Test"));
      mainPanel.add(keyListenerLabel);
      mainPanel.add(keyBindingLabel);

      keyListenerLabel.setBorder(BorderFactory.createLineBorder(Color.black));
      keyBindingLabel.setBorder(BorderFactory.createLineBorder(Color.black));

      mainPanel.addKeyListener(new KeyAdapter() {

         @Override
         public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
               keyListenerLabel.setText("KeyListener: left pressed");
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
               keyListenerLabel.setText("KeyListener: right pressed");
            }
         }
      });

      int condition = JPanel.WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = mainPanel.getInputMap(condition);
      ActionMap actionMap = mainPanel.getActionMap();

      KeyStroke leftArrowStroke = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
      KeyStroke rightArrowStroke = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
      inputMap.put(leftArrowStroke, leftArrowStroke.toString());
      inputMap.put(rightArrowStroke, rightArrowStroke.toString());
      actionMap.put(leftArrowStroke.toString(), new AbstractAction() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            keyBindingLabel.setText("Key Bindings: left Arrow Pressed");
         }
      });
      actionMap.put(rightArrowStroke.toString(), new AbstractAction() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            keyBindingLabel.setText("Key Bindings: right Arrow Pressed");
         }
      });


      mainPanel.setFocusable(true);
      mainPanel.requestFocusInWindow();

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
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