public class SuperWindow {
   protected abstract JLabel getLabel();

   protected void updateLabel() {
     getLabel().setText("foo");
   }
}

public class WindowA extends SuperWindow {
   private JLabel labelA;
   //...

   @Override
   protected JLabel getLabel() {
      return labelA;
   }

   private void somethingHappened() {
      updateLabel();
   }
}