interface D {
   static final String ORDER_PROPERTY="ORDER";
   void setOrder(Order order);
   Order getOrder();
}

class B implements D {
   // delegate object to implement support for event listeners and event firing
   private java.beans.PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
   private Order order = null; // field that holds current order
   @Override
   public void setOrder(Order order) {
      Order old = this.order;
      this.order = order;
      propertyChangeSupport.firePropertyChange(ORDER_PROPERTY, old, order);
   }
   // more B code here
}