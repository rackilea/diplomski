import java.awt.CardLayout;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

class GUIRetry implements ActionListener {

public static void main(String[] args) {
    new GUIRetry().GUI();
}

public JFrame f;
public JButton button;
public JTextField zero;
public JTextField one;
public JTextField two;
public JTextField three;
public JTextField four;
public JTextField five;
public JTextField six;
public JTextField seven;
public JTextField eight;
public JPanel content;
public JPanel panel2;
public ScheduleGetterGUI combo;

public String[] classes = new String[9];

final static String PANEL_1 = "Panel 1";
final static String PANEL_2 = "Panel 2";

CardLayout cardLayout;

public void GUI() {

    f = new JFrame("SchoolHelper");
    f.setSize(275, 600);
    f.setResizable(false);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    content = new JPanel(new GridLayout(10, 2));
    content.setBorder(BorderFactory.createLineBorder(Color.black, 2));

    JLabel enterzero = new JLabel("Enter Zero Period");
    content.add(enterzero);
    zero = new JTextField(15);
    content.add(zero);

    JLabel enterone = new JLabel("Enter First Period");
    content.add(enterone);
    one = new JTextField(15);
    content.add(one);

    JLabel entertwo = new JLabel("Enter Second Period");
    content.add(entertwo);
    two = new JTextField(15);
    content.add(two);

    JLabel enterthree = new JLabel("Enter Third Period");
    content.add(enterthree);
    three = new JTextField(15);
    content.add(three);

    JLabel enterfour = new JLabel("Enter Fourth Period");
    content.add(enterfour);
    four = new JTextField(15);
    content.add(four);

    JLabel enterfive = new JLabel("Enter Fifth Period");
    content.add(enterfive);
    five = new JTextField(15);
    content.add(five);

    JLabel entersix = new JLabel("Enter Sixth Period");
    content.add(entersix);
    six = new JTextField(15);
    content.add(six);

    JLabel enterseven = new JLabel("Enter Seventh Period");
    content.add(enterseven);
    seven = new JTextField(15);
    content.add(seven);

    JLabel entereight = new JLabel("Enter Eight Period");
    content.add(entereight);
    eight = new JTextField(15);
    content.add(eight);

    JLabel space = new JLabel("");
    content.add(space);

    button = new JButton("Enter Classes");
    button.setActionCommand("submit");
    button.addActionListener(this);
    content.add(button);

    cardLayout = new CardLayout();

    f.getContentPane().setLayout(cardLayout);

    f.getContentPane().add(content);

    panel2 = new JPanel();

    panel2.add(new JLabel("This is panel 2"));

    f.add(content, PANEL_1);
    f.add(panel2, PANEL_2);

    f.setVisible(true);
}

public void actionPerformed(ActionEvent e) {
    if ("submit".equals(e.getActionCommand())) {

        String zerot = zero.getText();
        classes[0] = zerot;

        String onet = one.getText();
        classes[1] = onet;

        String twot = two.getText();
        classes[2] = twot;

        String threet = zero.getText();
        classes[3] = threet;

        String fourt = zero.getText();
        classes[4] = fourt;

        String fivet = five.getText();
        classes[5] = fivet;

        String sixt = zero.getText();
        classes[6] = sixt;

        String sevent = zero.getText();
        classes[7] = sevent;

        String eightt = eight.getText();
        classes[8] = eightt;

        cardLayout.show(f.getContentPane(), PANEL_2);//Also "Panel 2" can be used as the second argument 

        System.out.println(Arrays.toString(classes));
    }
}
}