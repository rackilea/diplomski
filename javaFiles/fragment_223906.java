import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfFromUserInput {

    private JFrame frame;
    private JTextArea area;
    private JButton button;
    private Document document;
    private PdfWriter writer;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PdfFromUserInput().createAndShowGui();
            }
        });
    }

    public void openPdf() throws FileNotFoundException, DocumentException {
        document = new Document(PageSize.A4, 30, 30, 30, 30);
        writer = PdfWriter.getInstance(document, new FileOutputStream("myFile.pdf"));
        document.open();
    }

    public void closePdf() {
        document.close();
    }

    public java.awt.Image getImageFromComponent(JComponent component) throws DocumentException {
        BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
        component.paint(image.getGraphics());
        return image;
    }

    public void addImageToDocument(java.awt.Image img) throws IOException, DocumentException {
        Image image = Image.getInstance(writer, img, 1);
        image.scalePercent(50);
        document.add(image);
        System.out.println("printed!");
    }

    public void createAndShowGui() {
        frame = new JFrame("PDF creator");
        area = new JTextArea(10, 30);
        area.setBorder(BorderFactory.createLineBorder(Color.RED));
        button = new JButton("Create PDF");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    openPdf();
                    java.awt.Image img = getImageFromComponent(area);
                    addImageToDocument(img);
                    img = getImageFromComponent(button);
                    addImageToDocument(img);
                    closePdf();
                } catch (DocumentException e1) {
                    e1.printStackTrace();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        frame.add(area, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}