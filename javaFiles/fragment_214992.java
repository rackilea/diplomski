btn.setActionListener(new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        java.awt.datatransfer.StringSelection strsel = new java.awt.datatransfer.StringSelection(textField1.getText() + textField2.getText());
        java.awt.datatransfer.Clipboard clbrd = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
        clbrd.setContents(strsel, strsel);
    }
});