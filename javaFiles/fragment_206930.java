class f extends Funnction implements AJAX_Handler
 {
   private AJAX_HandlerImpl impl = new AJAX_HandlerImpl();

   public boolean f(Event e) {
      ...
    return true;
    }

   public void request(int i1,int i2,int i3,int i4) {
          impl.request(i1,i2,i3,i4);
    }
  }