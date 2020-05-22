import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class MigLay extends JFrame {

    private MigLay() {
        super("Button Layout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new MigLayout("debug",
            "10[45%!,fill]5[35%!,fill]10[20%!,fill]",
            "10[60%!,fill]5[40%!,fill]"));
        createPanels();
        pack();
        setVisible(true);
    }

    private void createPanels() {
        JPanel panel1 = new JPanel(), panel2 = new JPanel(), panel3 = new JPanel(), panel4 = new JPanel();
        JLabel label = new JLabel("Panel 1");
        panel1.add(label);

        label = new JLabel("Panel 2");
        panel2.add(label);

        label = new JLabel("Panel 3");
        panel3.add(label);

        label = new JLabel("Panel 4");
        panel4.add(label);

        add(panel1, "cell 0 0 1 1, grow");
        add(panel2, "cell 1 0 1 1, grow");
        add(panel3, "cell 2 0 1 2, grow");
        add(panel4, "cell 0 1 2 1, grow");
    }

    public static void main(String[] args) {
        new MigLay();
    }
}