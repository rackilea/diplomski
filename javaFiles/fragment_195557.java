import javax.swing.*;
import java.awt.*;

public class grafica extends JFrame {

    private JPanel p1, p2, p3, p4;
    private JButton aggiungi, affitta, reso, cerca, stampa;
    private JTextArea a1;
    private JTextField n1;
    private JLabel l1;

    public grafica() {
        // creating panels
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p1.setLayout(new GridLayout(2, 1));
        p3.setLayout(new GridLayout(5, 1));

        // creating elements
        aggiungi = new JButton("Aggiungi");
        affitta = new JButton("Affitta");
        reso = new JButton("Reso");
        cerca = new JButton("Cerca");
        stampa = new JButton("Stampa");
        n1 = new JTextField(10);
        l1 = new JLabel("Taglia: ");

        // adding elements
        p2.add(l1);
        p2.add(n1);
        p3.add(aggiungi);
        p3.add(affitta);
        p3.add(reso);
        p3.add(cerca);
        p3.add(stampa);
        p2.add(p3);

        // added part
        JPanel p2Holder = new JPanel();
        p2Holder.setLayout(new BoxLayout(p2Holder, BoxLayout.Y_AXIS));
        p2Holder.add(Box.createVerticalGlue());
        p2Holder.add(p2);
        p2Holder.add(Box.createVerticalGlue());

        p1.add(p2Holder);

        a1 = new JTextArea(20, 20);
        a1.setEditable(false);
        p1.add(a1);
        p1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
        p2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));

        p3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.green));

        this.setVisible(true);
        this.getContentPane().add(p1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public static void main(String[] args) {
        new grafica();
    }
}