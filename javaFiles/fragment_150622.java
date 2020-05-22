private static void drawTableAtTheEndOfPageAndWholeDocument
  (Document document, PdfWriter writer, PdfPTable datatable) 
  {
     datatable.setTotalWidth(document.right() - document.left());

     if (writer.getVerticalPosition(false) - datatable.getTotalHeight()
         - document.bottom() < 0) { 

      // new page if there is too little space for the final table on 
      // current page
        document.newPage();
     }

     datatable.writeSelectedRows(0, -1, document.left(),
     datatable.getTotalHeight() + document.bottom(), 
     writer.getDirectContent());
  }