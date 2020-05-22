import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

public class MainGui {
   public MainGui() {
      new WizardPanel().setVisible(true);
   }

   public static void main(String[] args) {
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         new MainGui();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}

class WizardPanel extends JDialog {
   private JPanel cardPanel, buttonPanel;
   private JButton next, previous;
   private CardLayout c1;
   private SimpleModel simpleModel = new SimpleModel();

   private FileSelector fileSelector;
   private DelemeterSelector delemeterSelector;

   private int count = 1;

   public WizardPanel() {
      fileSelector = FileSelector.getInstance();
      delemeterSelector = DelemeterSelector.getInstance();

      fileSelector.setModel(simpleModel); //!!
      delemeterSelector.setModel(simpleModel); //!!

      cardPanel = new JPanel();
      c1 = new CardLayout();
      cardPanel.setLayout(c1);

      cardPanel.add(fileSelector, "1");
      cardPanel.add(delemeterSelector, "2");

      c1.show(cardPanel, "1");

      buttonPanel = new JPanel();
      buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

      next = new JButton("Next");
      next.addActionListener(new NextButtonAction());
      previous = new JButton("Previous");

      buttonPanel.add(next);
      buttonPanel.add(previous);

      // Creating the GUI
      this.setLayout(new BorderLayout());
      this.add(cardPanel, "Center");
      this.add(buttonPanel, "South");

      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      this.setResizable(true);
      this.pack();
      this.setVisible(true);

   }

   private class NextButtonAction implements ActionListener {
      public void actionPerformed(ActionEvent ae) {

         // c1.show(cardPanel, "2");
         c1.next(cardPanel); //!!

      }
   }
}

class FileSelector extends JPanel {
   private JLabel fileName, description;
   private JTextField fileTxt;
   private JButton browse;

   private GridBagLayout gbl;
   private GridBagConstraints gbc;
   private SimpleModel simpleModel;

   private static FileSelector instance = null;

   private FileSelector() {
      // Intializing instance variables
      fileName = new JLabel("File Name: ");
      description = new JLabel("Specify the source of the data");

      fileTxt = new JTextField(10);

      browse = new JButton("Browse");
      browse.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            if (simpleModel != null) {
               simpleModel.setFileText(fileTxt.getText());
            }
         }
      });

      gbl = new GridBagLayout();
      gbc = new GridBagConstraints();

      // Creating GUI
      this.setLayout(gbl);

      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.fill = GridBagConstraints.BOTH;
      this.add(description, gbc);

      gbc.gridx = 1;
      gbc.gridy = 2;
      gbc.weightx = 1.0;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.insets = new Insets(0, 10, 0, 0);
      this.add(locationPanel(), gbc);

      this.setBorder(BorderFactory.createEmptyBorder());
   }

   public void setModel(SimpleModel simpleModel) {
      this.simpleModel = simpleModel;
   }

   private JPanel locationPanel() {
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());

      panel.add(fileName);
      panel.add(fileTxt);
      panel.add(browse);

      return panel;
   }

   public static FileSelector getInstance() {
      if (instance == null) {
         instance = new FileSelector();
      }

      return instance;
   }
}

class DelemeterSelector extends JPanel {
   private JLabel description;
   private JRadioButton tabBtn, semicolanBtn, commaBtn, spaceBtn;
   private JTextArea txtArea;
   private JScrollPane scroll;
   private ButtonGroup btnGroup;

   private GridBagLayout gbl;
   private GridBagConstraints gbc;
   private SimpleModel simpleModel;

   private static DelemeterSelector instance = null;

   private DelemeterSelector() {
      description = new JLabel(
            "What delemeter separates your fields? Select the appropreiate delemeter");

      tabBtn = new JRadioButton("Tab");
      semicolanBtn = new JRadioButton("Semicolan");
      commaBtn = new JRadioButton("Comma");
      spaceBtn = new JRadioButton("Space");

      btnGroup = new ButtonGroup();
      btnGroup.add(tabBtn);
      btnGroup.add(semicolanBtn);
      btnGroup.add(commaBtn);
      btnGroup.add(spaceBtn);

      txtArea = new JTextArea(20, 70);

      scroll = new JScrollPane(txtArea);

      gbl = new GridBagLayout();
      gbc = new GridBagConstraints();

      this.setLayout(gbl);

      // Creating the GUI
      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.insets = new Insets(20, 0, 0, 0);
      this.add(description, gbc);

      gbc.gridx = 1;
      gbc.gridy = 2;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.insets = new Insets(20, 0, 0, 0);
      this.add(radioPanel(), gbc);

      gbc.gridx = 1;
      gbc.gridy = 3;
      gbc.insets = new Insets(10, 0, 0, 0);
      gbc.fill = GridBagConstraints.BOTH;
      this.add(scroll, gbc);
   }

   private JPanel radioPanel() {
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());

      panel.add(tabBtn);
      panel.add(semicolanBtn);
      panel.add(commaBtn);
      panel.add(spaceBtn);

      panel.setBorder(BorderFactory
            .createTitledBorder("Choose the Delimeter that seperates your fields"));

      return panel;
   }

   //!!
   public void setModel(final SimpleModel simpleModel) {
      this.simpleModel = simpleModel;
      simpleModel.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent evt) {
            if (SimpleModel.FILE_TEXT.equals(evt.getPropertyName())) {
               txtArea.append("File Text: " + simpleModel.getFileText() + "\n");
            }         
         }
      });
   }

   public static DelemeterSelector getInstance() {
      if (instance == null) {
         instance = new DelemeterSelector();
      }

      return instance;
   }
}

class SimpleModel {
   public static final String FILE_TEXT = "file text";
   private SwingPropertyChangeSupport pcSupport = 
      new SwingPropertyChangeSupport(this);
   private String fileText;

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }

   public void setFileText(String fileText) {
      String oldValue = this.fileText;
      String newValue = fileText;
      this.fileText = fileText;
      pcSupport.firePropertyChange(FILE_TEXT, oldValue , newValue);

   }

   public String getFileText() {
      return fileText;
   }

}