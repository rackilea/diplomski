public class ViewController extends Observable implements ActionListener {

    public ViewController(Observer observer) {
        addObserver(observer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action Performed");
        setChanged();
        JComboBox comboBox = (JComboBox) e.getSource();
        notifyObservers(comboBox.getSelectedItem().toString());
    }
}