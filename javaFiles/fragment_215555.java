import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

public class PdfHeaderDecorator extends PdfPageEventHelper
{

  public PdfHeaderDecorator()
  {
    super();
  }

  public void onEndPage(PdfWriter writer, Document document)
  {
    PdfPTable tableF = new PdfPTable(3);

    try
    {

      tableF.setWidths(new int[]
      { 24, 24, 2 });
      tableF.setTotalWidth(527);
      tableF.setLockedWidth(true);
      tableF.getDefaultCell().setFixedHeight(9);
      tableF.getDefaultCell().setBorder(Rectangle.BOTTOM);
      tableF.addCell(new Phrase("SOME Text"));
      tableF.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
      tableF.addCell(new Phrase(String.format("page %d ", writer.getPageNumber())));
      PdfPCell cell = new PdfPCell(new Phrase("bla bla bla"));
      cell.setBorder(Rectangle.BOTTOM);
      tableF.addCell(cell);
      tableF.writeSelectedRows(0, -1, 34, 30, writer.getDirectContent());

    }
    catch (DocumentException de)
    {
      throw new ExceptionConverter(de);
    }
  }
}