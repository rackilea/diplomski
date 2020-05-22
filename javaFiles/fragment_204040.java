JProgressBar progress1 = new JProgressBar();
JButton allButton = new JButton("Klick Mich!");
allButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        progress1.setValue(50);
        main.infoBox("Hallo Welt!", "Hallo Welt!");    
    }
});