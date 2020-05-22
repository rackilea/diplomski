import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

    public MainFrame(String title) {
        super(title);
        setSize(new Dimension(600, 400));
        setResizable(false);
        //setLayout(new BorderLayout());// no need. its the default for JFrame
        JPanel search = new JPanel();
        search.setLayout(new FlowLayout(FlowLayout.LEFT));
        //search.setSize(new Dimension(300,400)); //let layout manager set size
                                                  //set preferred size if needed
        JLabel ksLb = new JLabel("Search:");
        JTextField ksTf = new JTextField(20);
        JButton ksOK = new JButton("Click Me");
        search.add(ksLb);
        search.add(ksTf);
        search.add(ksOK);
        add(search, BorderLayout.NORTH); //add search to content pane

        //construct a container to hold all the rest
        //set border layout to it
        JPanel mainPanel = new JPanel(new BorderLayout());
        //add content to mainPanel:
        //add result to NORTH 
        //add a JPanel to hold list and label to CENTER 
        add(mainPanel, BorderLayout.CENTER);//main to content pane
        setVisible(true);
    }
}