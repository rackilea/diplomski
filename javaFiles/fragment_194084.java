package AppPackage;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

        public class Test {
            JFrame frame = new JFrame("Test");
            JPanel panel = new JPanel();
            JTextField option = new JTextField("HI", 10);
            static String optionString;

            public Test() {
               option.getDocument().addDocumentListener(new DocumentListener() {

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        warn();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        warn();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        warn();
                    }

                    public void warn() {
                        optionString = option.getText();
                        System.out.println(optionString);
                    }
                });
                panel.add(option);
                frame.add(panel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }

              public static void main(String[] args) {
                    SwingUtilities.invokeLater(new Runnable() {
                         public void run() {
                             new Test();
                         }
                    });
              }
      }