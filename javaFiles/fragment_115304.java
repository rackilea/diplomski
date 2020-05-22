public class MyTree extends Tree {
   private Event currentEvent;

   ... constructors...

   // Call this method from within the onSelection method to determine if the shift key
   // was pressed.
   public boolean isShiftPressed() {
      return currentEvent != null ? currentEvent.getShiftKey() : false;
   }

   @Override
   public void onBrowserEvent(Event event) {
     currentEvent = event;
     super.onBrowserEvent(event);
     currentEvent = null;
   }
}