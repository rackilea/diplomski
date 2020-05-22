private class DummyDisplay implements Display  {

   private List<ClickHandler> addButtonClickHandlers;
   public void addAddButtonClickHandler(ClickHandler handler) {
       addButtonClickHandlers.add(handler);
   }
   public void fireAddButtonClick() {
       for (ClickHandler h in addButtonClickHandlers) {
              h.onClick(new ClickEvent());
       }
   }
   // .... 
}