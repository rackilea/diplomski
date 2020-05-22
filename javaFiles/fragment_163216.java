public class MyLongPressCustomButton extends Button{
      MyDelegate delegate;

      public MyLongPressCustomButton (MyDelegate delegate){
          this.delegate = delegate;
      }

      private void cancelLongpress() {        
        if (null  != delegate) {
            delegate.cancelLongPress();
        }
     }              
 }