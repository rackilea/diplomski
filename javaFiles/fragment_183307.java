import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PrintableDemo1 implements Printable {

  public int print(Graphics g, PageFormat pf, int pageIndex) {

    StringBuilder builder = new StringBuilder();
    builder.append("Test Result:").append("\n")
    .append("First Line").append("\n")
            .append("Second Line").append("\n")
            .append("Third Line").append("\n")
            .append("Fourth Line").append("\n")
            .append("Last Line");

    if (pageIndex != 0)
      return NO_SUCH_PAGE;

    Graphics2D g2 = (Graphics2D) g;
    g2.setFont(new Font("Serif", Font.PLAIN, 12));
    g2.setPaint(Color.black);
    myDrawString(g2, builder.toString(), 100, 100);

    return PAGE_EXISTS;
  }

  private void myDrawString(Graphics g, String text, int x, int y) {
      for (String line : text.split("\n"))
        g.drawString(line, x, y += g.getFontMetrics().getHeight());
  }

  public static void main(String[] args) {

    PrinterJob pj = PrinterJob.getPrinterJob();
    pj.setPrintable(new PrintableDemo1());

    try {
      pj.print();
    } catch (PrinterException e) {
      e.printStackTrace();
    }

  }

}