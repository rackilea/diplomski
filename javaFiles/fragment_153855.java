public class Ngjyra extends JFrame implements ActionListener {

JCheckBox kuqe, blu;
JButton veprimi, ok;

public Ngjyra() {
    setLayout(new FlowLayout());
    kuqe = new JCheckBox("Kuqe");
    add(kuqe);
    blu = new JCheckBox("Blu");
    add(blu);

    veprimi = new JButton("Kryej Veprimin");
    add(veprimi);
    veprimi.addActionListener(this);

}

public void actionPerformed(ActionEvent e) {
    if (e.getSource() == veprimi) {
        if (kuqe.isSelected()) {
            this.getContentPane().setBackground(Color.RED);
        } else if (blu.isSelected()) {
            this.getContentPane().setBackground(Color.BLUE);
        }
    }

}

public static void main(String args[])

{
    Ngjyra ob = new Ngjyra();
    ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ob.setSize(900, 900);
    ob.setVisible(true);
}
}