import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class ResizeTst {

    JFrame myMainWindow = new JFrame("This is my title");
    JPanel firstPanel = new JPanel();

//Components
    JButton compAth = new JButton();
    JButton viewAth = new JButton();
    JButton updateRD = new JButton();
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    String[] fontFamilies = ge.getAvailableFontFamilyNames();
    Font fontT5 = new Font(Font.SANS_SERIF, Font.BOLD, 25);
///////////

    public void runGUI() {
        myMainWindow.setBounds(10, 10, 1296, 756); // don't guess the size (1)
        myMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myMainWindow.setLayout(new GridLayout(1, 1));
        createFirstPanel();
        myMainWindow.getContentPane().add(firstPanel);
        myMainWindow.pack(); // 1) Make it mininum size needed
        myMainWindow.setMinimumSize(myMainWindow.getSize());
        myMainWindow.setVisible(true);
    }

    public void createFirstPanel() {
        //firstPanel.setLayout(null);
        firstPanel.setLayout(new GridLayout(1,0,50,50));
        firstPanel.setBorder(new EmptyBorder(50,50,50,50));
        Insets buttonMargin = new Insets(20, 20, 20, 20);

        compAth.setText("<html><CENTER>Compare<br>Athletes</CENTER></html>");
        compAth.setMargin(buttonMargin);
        compAth.setFont(fontT5);
        firstPanel.add(compAth);

        viewAth.setMargin(buttonMargin);
        viewAth.setText("<html><CENTER>View<br>Athletes</CENTER></html>");
        viewAth.setFont(fontT5);
        firstPanel.add(viewAth);

        updateRD.setMargin(buttonMargin);
        updateRD.setText("<html><CENTER>Update<br>Running<br>Details</CENTER></html>");
        updateRD.setFont(fontT5);
        firstPanel.add(updateRD);
    }

    public static void main(String[] args) {
        // should be on the EDT!
        ResizeTst rt = new ResizeTst();
        rt.runGUI();
    }
}