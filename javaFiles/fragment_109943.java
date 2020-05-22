protected void bind() {
   display.addAddButtonClickHandler(new ClickHandler() {
       public void onClick(ClickEvent) {
          fireAdded();
       } 
   });
} 

// The fireAdded function can be tested independenty of the Display, potentially with 
// a mock EventBus
protected void fireAdded() {
   event.fireEvent(....)
}