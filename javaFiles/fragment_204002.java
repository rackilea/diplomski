import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

public class CustomPasteAction extends AbstractAction implements ClipboardOwner {

    /** */
    private static final long serialVersionUID = 1L;

    public CustomPasteAction(String text, ImageIcon icon,
                                             String desc, Integer mnemonic) {
        super(text, icon);
        putValue(SHORT_DESCRIPTION, desc);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    public CustomPasteAction() {
        super("Custom Paste Action", null);
        putValue(SHORT_DESCRIPTION, "My custom paste action");
        putValue(MNEMONIC_KEY, KeyEvent.VK_V);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Thread(new Runnable() {
        public void run() {

            String temp = new CustomPasteAction().getClipboardContents();
            System.out.println("Processing: " + temp);
            JTextAreaExample.getTextArea().setText(temp);

        }
    }).start();
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        // do nothing
    }

    /**
      * Get the String residing on the clipboard.
      *
      * @return any text found on the Clipboard; if none found, return an
      * empty String.
      */
      public String getClipboardContents() {
        String result = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        //odd: the Object param of getContents is not currently used
        Transferable contents = null;
        try {
            contents = clipboard.getContents(null);
        } catch(IllegalStateException ise) {
            ise.printStackTrace();
        }
        boolean hasTransferableText =
          (contents != null) &&
          contents.isDataFlavorSupported(DataFlavor.stringFlavor)
        ;
        if ( hasTransferableText ) {
          try {
            result = (String)contents.getTransferData(DataFlavor.stringFlavor);
          }
          catch (UnsupportedFlavorException ex){
            //highly unlikely since we are using a standard DataFlavor
            System.out.println(ex);
            ex.printStackTrace();
          }
          catch (IOException ex) {
            System.out.println(ex);
            ex.printStackTrace();
          }
        }
        return result;
      }

      /**
       * Place a String on the clipboard, and make this class the
       * owner of the Clipboard's contents.
       */
       public void setClipboardContents( String aString ){
         StringSelection stringSelection = new StringSelection( aString );
         Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
         clipboard.setContents( stringSelection, this );
       }

}