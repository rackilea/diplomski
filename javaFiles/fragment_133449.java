import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class SharedPanelMain extends JPanel {
   private static final int PANEL_COUNT = 5;
   private SharedPanelModel sharedModel = new SharedPanelModel();
   private SharedPanel[] panels = new SharedPanel[PANEL_COUNT];

   public SharedPanelMain() {
      JTabbedPane tabbedPane = new JTabbedPane();
      for (int i = 0; i < panels.length; i++) {
         panels[i] = new SharedPanel(sharedModel);
         String title = "Panel " + (i + 1);
         tabbedPane.add(title, panels[i]);
      }

      add(tabbedPane);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("SharedPanel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new SharedPanelMain());
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

class SharedPanelModel {
   public static final String[] MODEL_DATA = { "one", "two", "three", "four",
         "five" };
   private DefaultListModel listModel = new DefaultListModel();
   private PlainDocument textAreaDocument = new PlainDocument();
   private ListSelectionModel listSelectionModel = new DefaultListSelectionModel();

   public SharedPanelModel() {
      for (String datum : MODEL_DATA) {
         listModel.addElement(datum);
      }
   }

   public ListModel getListModel() {
      return this.listModel;
   }

   public Document getTextAreaDocument() {
      return textAreaDocument;
   }

   public ListSelectionModel getListSelectionModel() {
      return listSelectionModel;
   }

}

@SuppressWarnings("serial")
class SharedPanel extends JPanel {
   private SharedPanelModel model;
   private JList list = new JList();
   private JTextArea textArea = new JTextArea(20, 50);

   public SharedPanel(SharedPanelModel model) {
      this.model = model;

      list.setModel(model.getListModel());
      list.setSelectionModel(model.getListSelectionModel());
      textArea.setDocument(model.getTextAreaDocument());

      add(new JScrollPane(list));
      add(new JScrollPane(textArea));
   }

}