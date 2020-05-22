import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class NestedPanels extends JPanel {

    private static final String[] BTN_TEXTS = { "Say Hello", "Say You Look Good", "Say Sorry I'm Late" }; //three buttons
    //never used :   private static final int TITLE_POINTS = 3;
    public NestedPanels() {

        JPanel southBtnPanel = new JPanel(new GridLayout(3, 2, 1, 1));
        for (String btnText : BTN_TEXTS) {
            JButton b = new JButton(btnText);
            //add action listener
            b.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonClicked(e);//when button clicked, invoke method
                }
            });

            //alternative much shorter way to add action listener:
            //b.addActionListener(e -> buttonClicked());
            southBtnPanel.add(b);
        }
        setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setLayout(new BorderLayout());

        //this adds Box to the default  BorderLayout.CENTER position
        add(Box.createRigidArea(new Dimension(600, 600)));

        add(southBtnPanel, BorderLayout.SOUTH);
    }

    //respond to button clicked
    private void buttonClicked(ActionEvent e) {
        String msg = ((JButton)e.getSource()).getActionCommand()+" pressed" ;
        JOptionPane.showMessageDialog(this, msg ); //display button Action
    }

    private static void createAndShowGui() {
        NestedPanels mainPanel = new NestedPanels();
        JFrame frame = new JFrame("Date Sim 1.0");
        //no need to invoke twice frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //no need to invoke twice  frame.pack();
        //no need to invoke twice frame.setVisible(true);

        frame.getContentPane().add(mainPanel);

        /*
         * when posting images, use web resources that anyone can access
         *
        ImageIcon icon = new ImageIcon("C:/Users/wchri/Pictures/10346538_10203007241845278_2763831867139494749_n.jpg");
        JLabel label = new JLabel(icon);

        *this adds label to the default BorderLayout.CENTER position, which is already taken by
        *the Box. Only one (last) component will be added
        mainPanel.add(label);
        *
        */

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //remove all code which is not essential to the question
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGui();
            }
        });
    }
}