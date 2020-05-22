import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintTest {

    public static void main(String[] args) {
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName("Book 'em Danno");

        PageFormat pf = pj.defaultPage();
        pf.setOrientation(PageFormat.LANDSCAPE);
        Book book = new Book();
        for (int index = 0; index < 10; index++) {
            book.append(new Page(index + 1), pf);
        }
        pj.setPageable(book);
        if (pj.printDialog()) {
            try {
                pj.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static class Page implements Printable {

        private int page;

        public Page(int page) {

            this.page = page;

        }

        @Override
        public int print(Graphics graphics, PageFormat pf, int pageIndex) throws PrinterException {

            Graphics2D g2 = (Graphics2D) graphics;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            g2.translate(0f, 0f);
            FontMetrics fm = g2.getFontMetrics();
            String text = Integer.toString(page);

            double y = (pf.getImageableHeight() - fm.getHeight()) + fm.getAscent();
            double x = (pf.getImageableWidth() - fm.stringWidth(text)) / 2d;

            g2.drawString(text, (float)x, (float)y);

            System.out.println(pageIndex);

            return PAGE_EXISTS;
        }

    }

}