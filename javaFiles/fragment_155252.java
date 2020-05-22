textPane.getInputMap().put(KeyStroke.getKeyStroke("TAB"), "tab");
textPane.getActionMap().put("tab", new AbstractAction("tab"){
    private static final long serialVersionUID = -2621537943352838927L;

    public void actionPerformed(ActionEvent e){
        try {
            textPane.getDocument().insertString(textPane.getCaretPosition(), " ", null);//The " " is the html special character (tab) in plain text.
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }
});