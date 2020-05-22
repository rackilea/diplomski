import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;

class ProgDraftMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ProgDraft gui = new ProgDraft();
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui.setResizable(false);
                gui.pack();
                //gui.setSize(1000 , 1000);
                gui.setVisible(true);
            }
        });
    }
}

class ProgDraft extends JFrame {

    private ImageIcon image1;
    private JLabel label1;
    private JTextField textField1;

    ProgDraft() {

        /**
         * Main Panel
         */
        JPanel mainPanel = new JPanel(new BorderLayout());
        /**
         * *Title**
         */
        JLabel title = new JLabel("Perimeter Check", JLabel.CENTER);
        Font font = new Font("Gigi", Font.BOLD, 50);
        title.setFont(font);
        mainPanel.add(title, BorderLayout.PAGE_START);   // add title to top

        /**
         * *Info ANtipolo**
         */
        String text = "Ito kunware ang ANtipolo" + "<br>"
                + "Marami ditong landslide areas" + "<br>" + "<br>"
                + "Take care and stay safe!" + "<br>"
                + "I love my dogs" + "<br>" + "<br>" + "<br>"
                + "Please help!";
        JLabel dog = new JLabel("<html><div style=\"text-align: center;\">" + text + "</html>");
        dog.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(dog);   //   add dog to center

        /**
         * *Image** ==========>>>>>> Make sure to change the image name back.
         */
        ImageIcon pics = new ImageIcon(getClass().getResource("stackoverflow.png"));

        JLabel logo = new JLabel(pics);
        logo.setHorizontalAlignment(JLabel.CENTER);
        //logo.setBorder(BorderFactory.createEmptyBorder(10, 70, 0, 50));
        logo.setToolTipText("Ito raw kunware yung barangay.");

        /**
         *  Wrapper for text field and icon
         */
        JPanel iconFieldPanel = new JPanel(new BorderLayout());
        JTextField textField = new JTextField(10);    
        iconFieldPanel.add(logo);
        iconFieldPanel.add(textField, BorderLayout.PAGE_END);
        JPanel iconFieldWrapper = new JPanel();
        iconFieldWrapper.add(iconFieldPanel);

        mainPanel.add(iconFieldWrapper, BorderLayout.PAGE_END);  // add icon and field to bottom

        getContentPane().add(mainPanel);
    }
}