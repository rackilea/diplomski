string text = "0000";
int topBottomBorder = Rectangle.BOTTOM_BORDER | Rectangle.TOP_BORDER;    
using (Document document = new Document()) {
  PdfWriter writer = PdfWriter.GetInstance(document, STREAM);
  document.Open(); 
  PdfPTable parentTable = new PdfPTable(2);
  PdfPCell cell = new PdfPCell() {
    Phrase = new Phrase(text), Border = topBottomBorder
  };
  parentTable.AddCell(cell);

// in 'child' PdfPTable *ALL* PdfPCells set *WITH NO* border
  PdfPTable childTable = new PdfPTable(1);
  childTable.AddCell(new PdfPCell
    (
      (new BarcodeQRCode(text, 1, 1, null)).GetImage()
    ) 
    { Border = Rectangle.NO_BORDER, PaddingTop = 1 }
  );
  childTable.AddCell(new PdfPCell() { // row 2
    Border = Rectangle.NO_BORDER, Phrase = new Phrase(text)
  });

// 1. wrap childTable in PdfPCell and set top & bottom borders
  PdfPCell childTableCell = new PdfPCell(childTable) {
    Border = topBottomBorder
  };
// 2. add to main PdfPTable           
  parentTable.AddCell(childTableCell);
  document.Add(parentTable);
}