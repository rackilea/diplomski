import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class CaptureTextAreaEnter extends JPanel {
   private static final int COLS = 30;
   private static final int VIEW_ROWS = 12;
   private static final int ENTER_ROWS = 4;
   private JTextArea chatViewArea = new JTextArea(VIEW_ROWS, COLS);
   private JTextArea chatEnterArea = new JTextArea(ENTER_ROWS, COLS);

   public CaptureTextAreaEnter() {
      setLayout(new BorderLayout());
      add(new JScrollPane(chatViewArea), BorderLayout.CENTER);
      add(new JScrollPane(chatEnterArea), BorderLayout.SOUTH);

      chatViewArea.setFocusable(false);

      chatViewArea.setWrapStyleWord(true);
      chatEnterArea.setWrapStyleWord(true);
      chatViewArea.setLineWrap(true);
      chatEnterArea.setLineWrap(true);

      // start our set up of key bindings

      // to get the correct InputMap
      int condition = WHEN_FOCUSED;  
      // get our maps for binding from the chatEnterArea JTextArea
      InputMap inputMap = chatEnterArea.getInputMap(condition);
      ActionMap actionMap = chatEnterArea.getActionMap();

      // the key stroke we want to capture
      KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

      // tell input map that we are handling the enter key
      inputMap.put(enterStroke, enterStroke.toString());

      // tell action map just how we want to handle the enter key
      actionMap.put(enterStroke.toString(), new AbstractAction() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            String text = chatEnterArea.getText();
            chatEnterArea.setText("");
            chatViewArea.append(text + "\n");

            // *** you will want to send text to your 
            // *** PrintStream to the chat server here 
         }
      });
   }

   private static void createAndShowGui() {
      CaptureTextAreaEnter mainPanel = new CaptureTextAreaEnter();

      JFrame frame = new JFrame("CaptureTextAreaEnter");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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