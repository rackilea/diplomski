import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.PrinterResolution;

public class TestHiResPrinting {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
                aset.add(new PrinterResolution(300, 300, PrinterResolution.DPI));
                aset.add(new MediaPrintableArea(0, 0, 150, 100, MediaPrintableArea.MM));

                PrinterJob pj = PrinterJob.getPrinterJob();
                pj.setPrintable(new PrintTask());

                if (pj.printDialog(aset)) {
                    try {
                        pj.print(aset);
                    } catch (PrinterException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    // The number of CMs per Inch
    public static final double CM_PER_INCH = 0.393700787d;
    // The number of Inches per CMs
    public static final double INCH_PER_CM = 2.545d;
    // The number of Inches per mm's
    public static final double INCH_PER_MM = 25.45d;

    /**
     * Converts the given pixels to cm's based on the supplied DPI
     *
     * @param pixels
     * @param dpi
     * @return
     */
    public static double pixelsToCms(double pixels, double dpi) {
        return inchesToCms(pixels / dpi);
    }

    /**
     * Converts the given cm's to pixels based on the supplied DPI
     *
     * @param cms
     * @param dpi
     * @return
     */
    public static double cmsToPixel(double cms, double dpi) {
        return cmToInches(cms) * dpi;
    }

    /**
     * Converts the given cm's to inches
     *
     * @param cms
     * @return
     */
    public static double cmToInches(double cms) {
        return cms * CM_PER_INCH;
    }

    /**
     * Converts the given inches to cm's
     *
     * @param inch
     * @return
     */
    public static double inchesToCms(double inch) {
        return inch * INCH_PER_CM;
    }

    public static class PrintTask implements Printable {

        private BufferedImage img;

        public PrintTask() {
            double width = cmsToPixel(1, 72);
            double height = cmsToPixel(5, 72);

            img = new BufferedImage((int) Math.round(width), (int) Math.round(height), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            g2d.setColor(Color.RED);
            g2d.draw(new Rectangle2D.Double(0, 0, width - 1, height - 1));
            g2d.draw(new Line2D.Double(0, 0, width, height));
            g2d.draw(new Line2D.Double(0, height, width, 0));
            g2d.dispose();
        }

        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            int result = NO_SUCH_PAGE;
            if (pageIndex < 2) {
                Graphics2D g2d = (Graphics2D) graphics;
                double width = pageFormat.getImageableWidth();
                double height = pageFormat.getImageableHeight();

                System.out.println("Page width = " + width + " = " + pixelsToCms(width, 72));
                System.out.println("Page height = " + height + " = " + pixelsToCms(height, 72));

                g2d.translate((int) pageFormat.getImageableX(),
                                (int) pageFormat.getImageableY());
                double x = cmsToPixel(1, 72);
                double y = cmsToPixel(1, 72);
                System.out.println("Draw At " + x + "x" + y);
                g2d.drawRect(0, 0, (int)width - 1, (int)height - 1);
                g2d.drawImage(img, (int)x, (int)y, null);
                result = PAGE_EXISTS;
            }
            return result;
        }

    }
}