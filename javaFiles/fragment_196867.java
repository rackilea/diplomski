import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TestFileEx {
   public static void main(String[] args) {
      final FileEx fileEx = new FileEx();

      fileEx.addPropertyChangeListener(FileEx.SELECTION, new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent evt) {
            // TODO code to call when fileEx has changed selections

            String fileExSelection = evt.getNewValue().toString();

            // or

            String fileExSelection2 = fileEx.getSelection();            

         }
      });
   }
}