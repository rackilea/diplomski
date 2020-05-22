Timer timer = new Timer(5000, new ActionListener(){
    public void actionPerformed(ActionEvent e){
        color = Color.GREEN;
        repaint();
    }
});
timer.setRepeats(false);
timer.start();