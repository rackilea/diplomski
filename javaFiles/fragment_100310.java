import java.awt.*;
import java.awt.Dialog.ModalityType;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import javax.swing.*;
import javax.swing.text.*;

@SuppressWarnings("serial")
public class ApproveSelectionTest extends JPanel {
   private JTextArea textArea = new JTextArea(30, 60);

   public ApproveSelectionTest() {
      textArea.setEditable(false);
      textArea.setFocusable(false);

      JPanel btnPanel = new JPanel();
      btnPanel.add(new JButton(new MyGetFileAction("Get Text File Text")));

      setLayout(new BorderLayout());
      add(new JScrollPane(textArea), BorderLayout.CENTER);
      add(btnPanel, BorderLayout.PAGE_END);
   }

   private class MyGetFileAction extends AbstractAction {
      public MyGetFileAction(String text) {
         super(text);
      }

      public void actionPerformed(java.awt.event.ActionEvent arg0) {
         MyFileChooser myFileChooser = new MyFileChooser();
         int result = myFileChooser.showOpenDialog(ApproveSelectionTest.this);
         if (result == JFileChooser.APPROVE_OPTION) {
            Document doc = myFileChooser.getDocument();
            textArea.setDocument(doc);
         }
      };
   }

   private static void createAndShowGui() {
      ApproveSelectionTest mainPanel = new ApproveSelectionTest();

      JFrame frame = new JFrame("ApproveSelectionTest");
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

@SuppressWarnings("serial")
class MyFileChooser extends JFileChooser {
   private WorkOpen workOpen = null;
   private JDialog progressDialog = null;

   public MyFileChooser() {
   }

   @Override
   public void approveSelection() {
      JProgressBar progBar = new JProgressBar();
      progBar.setIndeterminate(true);
      Window win = SwingUtilities.getWindowAncestor(this);
      progressDialog = new JDialog(win, "Checking File", ModalityType.APPLICATION_MODAL);
      progressDialog.getContentPane().add(progBar);
      progressDialog.pack();
      progressDialog.setLocationRelativeTo(null);


      File file = getSelectedFile();

      workOpen = new WorkOpen(file);

      workOpen.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent pcEvt) {
            if (SwingWorker.StateValue.DONE == pcEvt.getNewValue()) {
               if (progressDialog != null) {
                  progressDialog.dispose();
               }

               try {
                  boolean bool = workOpen.get().booleanValue();
                  if (bool) {
                     superApproveSelection();
                  } else {
                     JOptionPane.showMessageDialog(MyFileChooser.this, "Invalid File Chosen");
                  }
               } catch (InterruptedException e) {
                  e.printStackTrace();
               } catch (ExecutionException e) {
                  e.printStackTrace();
               }
            }
         }
      });

      workOpen.execute();
      progressDialog.setVisible(true);

   }

   // ****** this is key *****
   private void superApproveSelection() {
      super.approveSelection();
   }

   public Document getDocument() {
      if (workOpen == null) {
         return null;
      } else {
         return workOpen.getDocument();
      }
   }
}

class WorkOpen extends SwingWorker<Boolean, Void> {
   private static final long SLEEP_TIME = 4 * 1000;
   private Document document = null;
   private File file = null;

   public WorkOpen(File file) {
      this.file  = file;
   }

   @Override
   protected Boolean doInBackground() throws Exception {
      if (file == null || !file.exists()) {
         return Boolean.FALSE;
      }
      Thread.sleep(SLEEP_TIME);
      String fileName = file.getName();
      if (fileName.contains(".txt")) {
         Scanner scan = new Scanner(file);
         StringBuilder stringBuilder = new StringBuilder();
         while (scan.hasNextLine()) {
            stringBuilder.append(scan.nextLine() + "\n");
         }

         document = new PlainDocument();
         document.insertString(0, stringBuilder.toString(), null);
         return Boolean.TRUE;
      }
      return Boolean.FALSE;
   }

   public Document getDocument() {
      return document;
   }

}