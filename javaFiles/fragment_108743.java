Timer timer = new Timer(5000, new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        panel.setVisible(true);
    }
});
timer.setRepeats(false);
timer.start();