Timer timer = new Timer(5000, new ActionListener(){
    public void actionPerformed(ActionEvent e){
        if (color.equals(Color.GREEN){
            color = Color.RED;
        } else {
            color = Color.GREEN;
        }
        repaint();
    }
});
timer.start();