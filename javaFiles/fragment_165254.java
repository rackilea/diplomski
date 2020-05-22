import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class OknoPizzaVlastna extends JFrame {

    private String nazvy[] = {
        "cesnak", "feferony", "hrasok", "cibula",
        "kecup", "tatarskaOmacka", "vajce",
        "kapia", "fazula", "kukurica", "ananas", "brokolica",
        "Niva", "Mozarella", "olivy", "inovec udeny", "articoky",
        "klobasa", "sampiony", "salama", "slanina", "hranolky", "tuniak",
        "sunka", "kuracie maso", "syr", "Morska zmes", "bolonska zmes"
    };

    JPanel ui= new JPanel(new GridLayout(0,1,4,4));

    private JCheckBox boxes[];

    public OknoPizzaVlastna() {
        ui.setBorder(new EmptyBorder(10,10,10,10));
        setContentPane(ui);
        boxes = new JCheckBox[nazvy.length];

        for (int i = 0; i < nazvy.length; i++) {
            createrCheckBox(i);
        }

        setTitle("Vlastna Pizza");
        pack();
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void createrCheckBox(int i) {
        boxes[i] = new JCheckBox(nazvy[i]);
        boxes[i].setBorder(new EmptyBorder(0,i*30,0,0));
        ui.add(boxes[i]);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run() {
                JFrame frame = new OknoPizzaVlastna();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}