copyBtn = new JButton(new AbstractAction("copy"){
    public void actionPerformed(ActionEvent e){
        Clipboard system = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection sel = new StringSelection(myTextField.getText());
        system.setContents(sel, sel);
    }    
});