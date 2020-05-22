Timer timer = new Timer(1000, new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        x = rand.nextInt(400) + 1;     
        y = rand.nextInt(400) + 1;
        repaint();   
    }
});