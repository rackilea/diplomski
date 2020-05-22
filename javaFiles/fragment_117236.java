buttonFlagDe.addActionListener (new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        MainFrame mainFrameDe = new MainFrame(ResourceBundle.getBundle("labels_de",new Locale ("de")));
        mainFrameDe.setVisible(true);
        mainFrameDe.setLocationRelativeTo(null);
        dispose();  
    }           
});