import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

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

   private class InputHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         urlText = textField.getText();
         // textArea.append(urlText);
         System.out.println(urlText);

         myModel.setURL(urlText);

         myModel.getContent(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
               if (SwingWorker.StateValue.DONE == evt.getNewValue()) {
                  pageTitle = myModel.getTitle();
                  myFrame.setTitle(pageTitle);
                  pageBody = myModel.getBody();
                  textArea.setText(pageBody);
                  System.out.println(pageBody);
               }
            }
         });
         // textArea.repaint();
      }
   }

   private static void createAndShowGui() {
      BrowserFrame frame = new BrowserFrame();
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

   public BrowserFrame() {
      BrowserPageReader myModel = new BrowserPageReader();
      setTitle("My Browser");
      Toolkit kit = Toolkit.getDefaultToolkit();
      Dimension screenSize = kit.getScreenSize();
      setSize(screenSize.width / 2, screenSize.height - 500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container contentPane = getContentPane();
      JTextField textField = new JTextField(20);
      BrowserPanel myPanel = new BrowserPanel(textField, myModel, this);
      contentPane.add(myPanel);
      contentPane.add(textField, BorderLayout.PAGE_START);
      setVisible(true);

   }
}

class BrowserPageReader {

   private URL myURL;
   // private String webURL;
   private String totalWebContent;
   private String htmlString;
   private String contentToPrint = " ";
   private String urlPath;
   private String urlHost;
   private String pageTitle;
   private String pageBody;
   private String formattedBody;

   public void setURL(String webURL) {
      try {
         myURL = new URL(webURL);
         urlPath = myURL.getPath();
         urlHost = myURL.getHost();

      } catch (MalformedURLException e) {
         JOptionPane.showMessageDialog(null, "URL is incorrectly formatted");
      }
   }

   public void getContent(PropertyChangeListener listener) {
      RetrieveWorker worker = new RetrieveWorker();
      worker.addPropertyChangeListener(listener);
      worker.execute();
   }

   private void retrieveContent() {
      try {
         Socket socket = new Socket(urlHost, 80);
         PrintWriter out = new PrintWriter(socket.getOutputStream());
         BufferedReader in = new BufferedReader(new InputStreamReader(
               socket.getInputStream()));
         out.print("GET " + urlPath + " HTTP/1.1\n");
         out.print("Host: " + urlHost + "\n");
         out.print("\n");
         out.flush();
         while ((totalWebContent = in.readLine()) != null) {
            // System.out.println(totalWebContent);
            htmlString = htmlString + totalWebContent;
            // System.out.println(contentToPrint);
         }
         // System.out.println("htmlString\n" + htmlString);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public String getTitle() {
      // !! retrieveContent();
      System.out.println(htmlString);
      pageTitle = htmlString.substring(htmlString.indexOf("<title>") + 7,
            htmlString.indexOf("</title>"));
      return pageTitle;
   }

   public String getBody() {
      String toDelete;
      String edited;
      // !! retrieveContent();

      pageBody = htmlString.substring(htmlString.indexOf("<body") + 5,
            htmlString.indexOf("</body>"));
      toDelete = pageBody.substring(0, pageBody.indexOf('<'));
      edited = pageBody.replace(toDelete, "");
      pageBody = edited;
      formattedBody = pageBody.replaceAll("<[^>]*>", "");
      // System.out.println(formattedBody);
      return formattedBody;

   }

   private class RetrieveWorker extends SwingWorker<Void, Void> {
      @Override
      protected Void doInBackground() throws Exception {
         retrieveContent();
         return null;
      }

   }
}