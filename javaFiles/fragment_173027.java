import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class BrowserPanel extends JPanel {

   private JTextField textField;
   private String urlText;
   private JTextArea textArea;
   private BrowserPageReader myModel;
   private String pageContent;
   private BrowserFrame myFrame;
   private String pageTitle;
   private String pageBody;

   public BrowserPanel(JTextField myTextField, BrowserPageReader model,
         BrowserFrame frame) {
      myFrame = frame;
      myModel = model;
      textField = myTextField;
      textField.addActionListener(new InputHandler());

      /*
       * JScrollPane areaScrollPane = new JScrollPane(textArea);
       * areaScrollPane.setVerticalScrollBarPolicy(
       * JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       * 
       * areaScrollPane.setPreferredSize(new Dimension(250,250));
       */
      textArea = new JTextArea(20, 40);
      textArea.setEditable(false);
      textArea.setWrapStyleWord(true);
      textArea.setLineWrap(true);
      JScrollPane scroll = new JScrollPane(textArea);

      add(scroll);
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);

   }

   private class InputHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         urlText = textField.getText();
         // textArea.append(urlText);

         myModel.setURL(urlText);
         pageTitle = myModel.getTitle();
         myFrame.setTitle(pageTitle);
         pageBody = myModel.getBody();
         textArea.setText(pageBody);
         System.out.println(pageBody); // This prints out exactly what Im
                                       // wanting
                                       // Its just a test
         textArea.repaint();
      }
   }

   private static void createAndShowGui() {
      BrowserFrame frame = new BrowserFrame();
      JTextField textField = new JTextField(10);
      BrowserPageReader myModel = new BrowserPageReader();
      BrowserPanel mainPanel = new BrowserPanel(textField, myModel, frame);

      frame.add(textField, BorderLayout.NORTH);
      frame.add(mainPanel, BorderLayout.CENTER);

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

class BrowserFrame extends JFrame {

}

class BrowserPageReader {

   public void setURL(String urlText) {
      // does nothing for now. for testing purposes.
   }

   public String getBody() {
      return "body"; // for testing purposes
   }

   public String getTitle() {
      return "title"; // for testing purposes
   }

}