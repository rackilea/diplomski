public class MyListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton myBtn = (AbstractButton) e.getSource();
        // call whatever methods needed on myBtn
    }
}