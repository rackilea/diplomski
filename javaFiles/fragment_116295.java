import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MTGSAMPServerReference extends JFrame implements ActionListener {

    public static Toolkit tk = Toolkit.getDefaultToolkit();
    static int ScrnWidth = ((int) tk.getScreenSize().getWidth());
    static int ScrnHeight = ((int) tk.getScreenSize().getHeight());

    private static final long serialVersionUID = 1L;
    private static JList list1;
    private static JButton next;

    public MTGSAMPServerReference() {
        // set flow layout for the frame
        this.getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING));
        Object[] data1 = { "Value 1", "Value 2", "Value 3", "Value 4", "Value 5" };

        JPanel controls = new JPanel( new BorderLayout(5,5) );

        list1 = new JList<Object>(data1);
        list1.setVisibleRowCount(5);
        next = new JButton("Next");
        next.addActionListener(this);
        // add list to frame
        controls.add(new JScrollPane(list1));
        controls.add(next, BorderLayout.PAGE_END);
        // adjust numbers as needed.
        controls.setBorder(new EmptyBorder(25,25,0,0));

        add(controls);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Next")) {
            int index = list1.getSelectedIndex();
            System.out.println("Index Selected: " + index);
            String s = (String) list1.getSelectedValue();
            System.out.println("Value Selected: " + s);
        }
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame f = new MTGSAMPServerReference();
        //Display the window.
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setSize(1200, 800);
        f.setLocationRelativeTo(null);
        list1.setSize(250, 250);
        list1.setLocation(0, 0);
        next.setSize(75, 25);
        next.setLocation(251, 276);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
        createAndShowGUI();
        }
        });
    }
}