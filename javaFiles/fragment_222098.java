public class DetailsPanel extends JPanel {

    private HashMap<String, String> logInMap = new HashMap<String, String>();

    private String curUsername = "";//the current logged in username

    public String getCurUsername() {
        return curUsername;
    }
    JTextField nameField;
    JTextField passField;

    JButton logIn;

    public DetailsPanel() {
        nameField = new JTextField(0);
        passField = new JTextField(0);

        logIn.addActionListener((e) -> {//login attempted
            if (logInMap.containsKey(nameField.getText())) {
                if (passField.getText().equals(logInMap.get(nameField.getText()))) {
                    //logged in
                    curUsername = nameField.getText();
                    fireActionPerformed();
                } else {
                    //wrong password, logged out
                    curUsername = "";

                }
            } else {
                logInMap.put(nameField.getText(), passField.getText());
                curUsername = nameField.getText();
                //create new account
            }

        });

        GridBagConstraints gCons = new GridBagConstraints();
        gCons.gridy = 0;
        gCons.gridx = 0;
        add(nameField, gCons);
        gCons.gridy = 1;
        add(passField, gCons);
    }

    public void addActionListener(ActionListener al) {
        listenerList.add(ActionListener.class, al);
    }

    protected void fireActionPerformed() {
        ActionListener[] listeners = listenerList.getListeners(ActionListener.class);
        if (listeners.length == 0) {
            return;
        }
        ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "validated");
        for (ActionListener listener : listeners) {
            listener.actionPerformed(evt);
        }
    }

}