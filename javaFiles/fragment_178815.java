public class Calc extends JFrame implements ActionListener {

    private Button button1;

    public Calc()
    {
        super();
        this.setSize(100, 100);
        this.setVisible(true);

        this.button1 = new JButton("1");
        this.button1.addActionListener(this);
        this.add(button1);
    }


    public static void main(String[] args) {

        Calc calc = new Calc();
        calc.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1)
    }  

}