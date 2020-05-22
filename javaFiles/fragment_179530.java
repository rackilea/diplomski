import javax.swing.*;
import java.awt.*;


public class FirstView {

    private JFrame frame;
    private JTextArea informacionText;  // not sure if that is needed as field

    public FirstView() {
        informacionText = new JTextArea();
        informacionText.setEditable(false);
        informacionText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        informacionText.setLineWrap(true);
        informacionText.append("Information, bla bla bla");


        JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                                                 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        scrollPane.setViewportView(informacionText);


        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());
        infoPanel.add(scrollPane);


        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(infoPanel, BorderLayout.NORTH);
        // TODO consider moving above code to an own method returning the left panel

        frame = new JFrame("title");

        frame.setLayout(new BorderLayout());
        frame.add(leftPanel, BorderLayout.WEST);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}