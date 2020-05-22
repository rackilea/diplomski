import java.awt.*;
import java.lang.reflect.*;
import java.util.List;

import javax.swing.*;

import org.apache.pdfbox.PDFReader;
import org.apache.pdfbox.pdfviewer.PageWrapper;
import org.apache.pdfbox.pdmodel.PDPage;

public class CustomPDFReader extends PDFReader {
/**
 * 
 */
private static final long serialVersionUID = 678451510308887925L;

public CustomPDFReader() {
    super();
}

public void setCurrentFile(String file) {
    try {
        Method m = getClass().getSuperclass().getDeclaredMethod("openPDFFile", 
                new Class<?>[]{String.class, String.class});
        m.setAccessible(true);
        m.invoke(this, file, null);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void main(String []args) {
    CustomPDFReader reader = new CustomPDFReader();
    // remove menubar
    JMenuBar menu = reader.getJMenuBar();
    menu.setVisible(false);

    JPanel header = new JPanel(new BorderLayout());

    JPanel firstLine = new JPanel();

    JLabel label = new JLabel("Label");
    firstLine.add(label);

    JPanel secondLine = new JPanel();

    JTextField text = new JTextField();
    text.setPreferredSize(new Dimension(100, 30));
    secondLine.add(text);

    JButton button = new JButton("Button");
    button.setPreferredSize(new Dimension(100, 30));
    secondLine.add(button);

    header.add(firstLine, java.awt.BorderLayout.NORTH);
    header.add(secondLine, java.awt.BorderLayout.SOUTH);

    reader.getContentPane().add(header, java.awt.BorderLayout.NORTH);

    // set default opened file
    reader.setCurrentFile("test.pdf");
    reader.showAllPages();
    reader.setVisible(true);
}

private void showAllPages() {
    try {
        Field pages = getClass().getSuperclass().getDeclaredField("pages");
        pages.setAccessible(true);
        List<PDPage> pagesList = (List<PDPage>) pages.get(this);

        Field documentPanel = getClass().getSuperclass().getDeclaredField("documentPanel");
        documentPanel.setAccessible(true);
        JPanel panel = (JPanel) documentPanel.get(this);
        panel.remove(0);
        GridLayout layout = new GridLayout(0, 1);
        panel.setLayout(layout);
        for(PDPage page : pagesList) {
            PageWrapper wrapper = new PageWrapper(this);
            wrapper.displayPage(page);
            panel.add(wrapper.getPanel());
        }
        pack();
    } catch(Exception e) {
        e.printStackTrace();
    }
}