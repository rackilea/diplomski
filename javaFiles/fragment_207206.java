import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


//public class DocumentListener {       // Fix: not a good name for the class since it is part of JVM
  public class DocumentEventDemo extends JFrame {   // easier than extends JPanel
      JPanel txtPanel, centerPanel;
      GridLayout grid;

      JTextField txtField;
      JTextArea txtArea;
      JFrame frame;
      JComponent newContentPane;

      FlowLayout flow;

      public DocumentEventDemo() {

          txtArea = new JTextArea();
          txtArea.getDocument().addDocumentListener(new MyDocumentListener());
          txtArea.getDocument().putProperty("txtArea", "MyDocumentListener");

//        txtField = new JTextField(10);    // 10 chars max
//        txtField.setText("12345");

          centerPanel = new JPanel();
          grid = new GridLayout(2,1,1,1);

          txtPanel = new JPanel();
          flow = new FlowLayout(FlowLayout.CENTER);
          txtPanel.setLayout(flow);

          //Adding control GUI fields to the only panel
          // txtPanel.add(txtArea);
          // txtPanel.add(txtField);


          // Forming the center view with GUI controls
          centerPanel.setLayout(grid);
//        centerPanel.add(txtPanel);
          centerPanel.add(txtArea);

          // Add Panels to the Frame
          getContentPane().add(centerPanel,"Center");

          this.setSize(500,200);
          this.validate();
          this.setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        newContentPane = getRootPane();
//        newContentPane.setOpaque(true);
//        frame.setContentPane(newContentPane);

}

    //MyEditor editor = new MyEditor(); // what is MyEditor?

    //javax.swing.event.DocumentListener mydocumentListener = new javax.swing.event.DocumentListener()

    // Make a class to define the inherited abstract methods, which are also events.
    class MyDocumentListener implements DocumentListener {
       String[] word=new String[50];
       String text; 
       int i=0;
       int y;
       int l;
       int len;

       public void changedUpdate(DocumentEvent documentEvent) {
           System.out.println("The text has been changed.");
       }

       public void insertUpdate(DocumentEvent documentEvent) {
           try {
               GetWord(documentEvent);
           } catch (BadLocationException ex) {
               Logger.getLogger(DocumentListener.class.getName()).log(Level.SEVERE, null, ex);
           }
       }

       public void removeUpdate(DocumentEvent documentEvent) {
           System.out.println("A character has been removed!");
       }

      private void GetWord(DocumentEvent documentEvent) throws BadLocationException {
          //get the type of event
          DocumentEvent.EventType type = documentEvent.getType();
          //check what is the event, hence what is the user doing  
          if (type.equals(DocumentEvent.EventType.INSERT)) {
              Document source = documentEvent.getDocument();

              y=documentEvent.getOffset();
              l=documentEvent.getLength();
              len=source.getLength();

              text = source.getText(y,l);
              if(text.equals(" "))
              {
                  for (int z=0;z<len;z++)
                  {
                      System.out.print(word[z]);
                  }
                  System.out.println("\n");
                  Arrays.fill(word,null); 
                  i=0;
              }

              word[i]=text;
              i++;
          } else  {
              System.out.println("A character has been removed!");
          } 
      }
    };  // DocumentListener class instantiation


//  editor. editArea.getDocument().addDocumentListener(mydocumentListener);


    public static void main(String args[]){
        new DocumentEventDemo();
    }

}   // TOP class