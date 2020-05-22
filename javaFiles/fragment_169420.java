public class ModalDialog extends JDialog implements ActionListener {

    private Option selection;

    public ModalDialog() {
        setModal(true);
        Button btn8 = new Button("human");
        btn8.addActionListener(this);

        Button btn9 = new Button("robot");
        btn9.addActionListener(this);

        setLayout(new GridBagLayout());
        add(btn8);
        add(btn9);

        pack();
    }

    public Option getSelection() {
        return selection;
    }

    public void actionPerformed(ActionEvent e) {
       //...
    }
}