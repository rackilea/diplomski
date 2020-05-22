source.addDragListener(new DragSourceListener() {
   public void dragStart(DragSourceEvent event) {
      // Only start the drag if needed
      if (iDoNotNeedToStartTheDrag) {
          event.doit = false;
      }
   }
   public void dragSetData(DragSourceEvent event) {
     // Provide the data of the requested type.
     if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
          event.data = "the data to transfert";
     }
   }
   public void dragFinished(DragSourceEvent event) {
     // At the end of the drag, if we need to do something on the source
   }
});