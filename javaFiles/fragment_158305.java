public JButton[] turneringer = null;
JButton AntallTurneringer = new JButton("Velg antall turneringer");

JPanel panel1 = new JPanel();
JPanel panel2 = new JPanel();

int d;

public GUI(){
    this.setTitle("Squash Turnering");
    this.setLayout(new GridLayout());
    this.setSize(500,500);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    panel1.setBackground(Color.BLACK);
    panel2.setBackground(Color.RED);

    AntallTurneringer.addActionListener(this);
    AntallTurneringer.setVisible(true);

    panel1.add(AntallTurneringer);
    add(panel1);

    add(panel2);
    panel2.setVisible(false);

    this.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent arg0) {
    if(arg0.getSource().equals(AntallTurneringer)){
        String tu = JOptionPane.showInputDialog(null, "number of buttons you want to add");
        d = Integer.parseInt(tu);

        turneringer = new JButton[d];
        for(int i = 0; i < d; i++){
            turneringer[i] = new JButton();
            turneringer[i].addActionListener(this);
            turneringer[i].setText("Turnering "+(i+1));
            turneringer[i].setVisible(true);
            turneringer[i].setSize(100, 100);
            panel2.add(turneringer[i]);
        }
        panel1.setVisible(false);
        panel2.setVisible(true);
    }
}}