/** 
    * A DiscManager is a container for DiscFields and manages proper delegation
    * of touch event handling.
    */
   private class DiscManager extends Manager {

      private int _maxRadius = 0;

      public DiscManager(long style){
         super(style);

         DiscField outerDisc = new DiscField(new String[] { "1", "2", "3", "4", "5", "6" }, 
               180, Color.BLUE);
         _maxRadius = outerDisc.getRadius();
         DiscField middleDisc = new DiscField(new String[] { "1", "2", "3", "4", "5" }, 
               120, Color.GRAY);
         middleDisc.setOffset(_maxRadius - middleDisc.getRadius());
         DiscField innerDisc = new DiscField(new String[] { "1", "2", "3", "4" }, 
               60, Color.RED);
         innerDisc.setOffset(_maxRadius - innerDisc.getRadius());

         // order matters here:
         add(outerDisc);
         add(middleDisc);
         add(innerDisc);
      }

      protected void sublayout(int width, int height) {
         setExtent(2 * _maxRadius, 2 * _maxRadius);

         // each disc needs to have the same x,y center to be concentric
         for (int i = 0; i < getFieldCount(); i++) {
            if (getField(i) instanceof DiscField) {
               DiscField disc = (DiscField) getField(i);
               int xCenter = _maxRadius - disc.getRadius();
               int yCenter = _maxRadius - disc.getRadius();
               setPositionChild(disc, xCenter, yCenter);
               layoutChild(disc, 2 * _maxRadius, 2 * _maxRadius);
            }
         }
      }

      protected boolean touchEvent(TouchEvent event) {
         int eventCode = event.getEvent();
         // Get the touch location, within this Manager
         int x = event.getX(1);
         int y = event.getY(1);

         if ((x >= 0) && (y >= 0) && (x < getWidth()) && (y < getHeight())) {
            int field = getFieldAtLocation(x, y);
            if (field >= 0) {
               DiscField df = null;
               for (int i = 0; i < getFieldCount(); i++) {
                  if (getField(field) instanceof DiscField) {
                     int r = ((DiscField)getField(field)).getRadius();
                     // (_maxRadius, _maxRadius) is the center of all discs
                     if ((x - _maxRadius) * (x - _maxRadius) + (y - _maxRadius) * (y - _maxRadius) <= r * r) {
                        df = (DiscField)getField(field);
                     } else {
                        // touch was not within this disc's radius, so the one slightly bigger
                        // should be passed this touch event                        
                        break;
                     }
                  }
               }
               // Let event propagate to child field
               return (df != null) ? df.touchEvent(event) : super.touchEvent(event);
            } else {
               if (eventCode == TouchEvent.DOWN) {                    
                  setFocus();
               }
               // Consume the event
               return true;
            }
         }
         // Event wasn't for us, let superclass handle in default manner
         return super.touchEvent(event);
      }
   }