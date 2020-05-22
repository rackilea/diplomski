KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);   
inputMap.put(enterKey, enterKey.toString());
actionMap.put(enterKey.toString(), new AbstractAction() {

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextArea txtArea = (JTextArea) e.getSource();
        txtArea.setText("");
    }
});