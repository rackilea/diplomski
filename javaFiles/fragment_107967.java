public class updateGUI extends JFrame implements ActionListener {

    private RecordTableGUI recordTableGUIToUpdateWhenOKIsClicked;

    public updateGUI(RecordTableGUI recordTableGUIToUpdateWhenOKIsClicked, ...) {
        this.recordTableGUIToUpdateWhenOKIsClicked = 
            recordTableGUIToUpdateWhenOKIsClicked;
        ...
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            newName = tf.getText();
            this.recordTableGUIToUpdateWhenOKIsClicked.setNewName(newName);
        }
    }
}