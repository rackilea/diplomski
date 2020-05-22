public abstract class Animal extends JButton implements ActionListener {
    private boolean actionFlag = false;

    public Animal() {
        addActionListener(this);
    }

    //some constructor
    //some functions

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.actionFlag = true;
        System.out.println(this.actionFlag);
    }
}