import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PrinterResolution;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PrintMe {

    public static void main(String[] args) {
        new PrintMe();
    }

    public PrintMe() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                TestPane testPane = new TestPane();

                JButton btn = new JButton("Print");
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
                        aset.add(MediaSizeName.ISO_A4);
                        aset.add(new PrinterResolution(300, 300, PrinterResolution.DPI));

                        PrinterJob pj = PrinterJob.getPrinterJob();
                        pj.setPrintable(new MultiPagePrintable(testPane));

                        if (pj.printDialog(aset)) {
                            try {
                                pj.print(aset);
                                testPane.getParent().invalidate();
                                testPane.getParent().validate();
                            } catch (PrinterException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(testPane));
                frame.add(btn, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel implements Scrollable {

        private BufferedImage img;

        public TestPane() {
            try {
                img = ImageIO.read(some image source);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(), img.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                int x = (getWidth() - img.getWidth()) / 2;
                int y = (getHeight() - img.getHeight()) / 2;
                g2d.drawImage(img, x, y, this);
                g2d.dispose();
            }
        }

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return new Dimension(200, 200);
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 128;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 128;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return false;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return false;
        }

    }

    public class MultiPagePrintable implements Printable {

        private JComponent component;
        private int lastPage = 0;
        private double yOffset;

        private Font footerFont;

        public MultiPagePrintable(JComponent component) {
            this.component = component;

            footerFont = new Font("Arial", Font.BOLD, 24);
        }

        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            int result = NO_SUCH_PAGE;

            String name = "I be mighty!";
            String page = Integer.toString(pageIndex);

            FontMetrics fm = graphics.getFontMetrics(footerFont);
            double footerHeight = fm.getHeight() + 4;

            double height = pageFormat.getImageableHeight() - footerHeight;
            component.setSize(component.getPreferredSize());

            if (lastPage != pageIndex) {
                lastPage = pageIndex;
                yOffset = height * pageIndex;
                if (yOffset > component.getHeight()) {
                    yOffset = -1;
                }
            }

            if (yOffset >= 0) {
                Graphics2D g2d = (Graphics2D) graphics.create();

                g2d.translate((int) pageFormat.getImageableX(),
                                (int) pageFormat.getImageableY());

                g2d.translate(0, -yOffset);
                component.printAll(g2d);
                g2d.translate(0, +yOffset);
                Shape footerArea = new Rectangle2D.Double(0, height, pageFormat.getImageableWidth(), footerHeight);
                g2d.setColor(Color.WHITE);
                g2d.fill(footerArea);
                g2d.setColor(Color.RED);
                g2d.draw(footerArea);

                g2d.setColor(Color.BLACK);


                g2d.translate(0, (pageFormat.getImageableHeight() - footerHeight));
                float x = 2;
                float y = (float)((footerHeight - fm.getHeight()) / 2d);
                g2d.drawString(name, x, y + fm.getAscent());

                x = (float)(pageFormat.getImageableWidth() - fm.stringWidth(page) - 2);
                g2d.drawString(page, x, y + fm.getAscent());

                g2d.dispose();
                result = PAGE_EXISTS;
            }
            return result;
        }

    }

}