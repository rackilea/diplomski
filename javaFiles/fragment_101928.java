import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GUI {

    private JTextField humanYears_TextField = new JTextField(3);
    private JTextField dogYears_TextField = new JTextField(3);
    private JButton convert_Button = new JButton("Convert");
    private JLabel greeting = new JLabel("Dog years to Human years!");
    private JFrame window = new JFrame();
    private JPanel content = new JPanel();

    public GUI() {
        content.setLayout(new FlowLayout());
        content.add(this.greeting);
        content.add(new JLabel("Dog Years: "));
        content.add(this.dogYears_TextField);
        content.add(this.convert_Button);
        content.add(new JLabel("Human Years: "));
        content.add(this.humanYears_TextField);

        window.add(content);

        window.setTitle("Dog Year Converter");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        window.pack();
        window.setLocationRelativeTo(null);
        //window.setVisible(true); //works here now
    }

    //our wrapper method so we can change visibility of our frame from outside the class
    void setVisible(boolean visible) {
        window.setVisible(visible);
    }

    public static void main(String[] args) {
        //Create Swing components on EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI dogYears = new GUI();
                dogYears.setVisible(true);//works here too
            }
        });
    }
}