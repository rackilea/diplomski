public class Calculator extends JFrame implements ActionListener, ItemListener {

JTextField numri1, numri2;
JCheckBox shuma, diferenca, shumezimi;
JButton veprimi, ok;
JTextField rezultati;
double n1, n2;
String n1tekst, n2tekst;

public Calculator() {
    setLayout(new FlowLayout());

    numri1 = new JTextField(10);
    add(numri1);

    numri2 = new JTextField(10);
    add(numri2);

    shuma = new JCheckBox("Shuma");
    add(shuma);
    shuma.addItemListener(this);

    diferenca = new JCheckBox("Diferenca");
    add(diferenca);
    diferenca.addItemListener(this);

    shumezimi = new JCheckBox("Shumezimi");
    add(shumezimi);
    shumezimi.addItemListener(this);

    veprimi = new JButton("Kryej Veprimin");
    add(veprimi);
    veprimi.addActionListener(this);

    rezultati = new JTextField(10);
    add(rezultati);

    ok = new JButton("OK");
    add(ok);

}

public void itemStateChanged(ItemEvent e) {
    n1 = Double.parseDouble(numri1.getText());
    n2 = Double.parseDouble(numri2.getText());
    if (e.getSource() == shuma) {
        String rez = shuma.isSelected() ? "" + (n1 + n2) : "";
        rezultati.setText(rez);
    } else if (e.getSource() == diferenca) {
        String rez = diferenca.isSelected() ? "" + (n1 - n2) : "";
        rezultati.setText(rez);
    } else if (e.getSource() == shumezimi) {
        String rez = shumezimi.isSelected() ? "" + (n1 * n2) : "";
        rezultati.setText(rez);
    }
}

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == veprimi) {
        n1 = Double.parseDouble(numri1.getText());
        n2 = Double.parseDouble(numri2.getText());
        if (shuma.isSelected()) {
            rezultati.setText("" + (n1 + n2));
        } else if (diferenca.isSelected()) {
            rezultati.setText("" + (n1 - n2));
        } else if (shumezimi.isSelected()) {
            rezultati.setText("" + (n1 * n2));
        }
    }
}

public static void main(String args[])

{
    Calculator ob = new Calculator();
    ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ob.setSize(900, 900);
    ob.setVisible(true);
}

}