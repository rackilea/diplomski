import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Example2 {

private static final int NB1 = 5;
private static final int NB2 = 13;
private static final int NB3 = 15;

public static void main(String[] args) {

    JFrame f = new JFrame();
    f.setTitle("Example2");
    f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    p1.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "JPanel 1"));
    for(int i=0; i<NB1; i++)
        p1.add(new JButton("Button " + i));

//    JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel p2 = new JPanel(new WrapLayout(FlowLayout.CENTER));
    p2.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "JPanel 2"));
    for(int i=NB1; i<NB2; i++)
        p2.add(new JButton("Button " + i));

    JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    p3.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "JPanel 3"));
    for(int i=NB2; i<NB3; i++)
        p3.add(new JButton("Button " + i));

    JPanel global = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL; // added
    gbc.weightx = 1.0f; // added
    gbc.gridy = 0;
    global.add(p1, gbc);
    gbc.gridy++;
    global.add(p2, gbc);
    gbc.gridy++;
    global.add(p3, gbc);

    f.add(global);
    f.pack();
    f.setVisible(true);

}

}