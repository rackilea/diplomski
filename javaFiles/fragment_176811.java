public class Cart2 extends JFrame implements ActionListener {
    JButton remove = new JButton("remove");
    NewClass newClass;

    public Cart2(NewClass newClass) {
        this.newClass = newClass;
        add(remove);

        remove.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == remove) {
            // NewClass nc = new NewClass();
            newClass.update(1000);
        }
    }

}