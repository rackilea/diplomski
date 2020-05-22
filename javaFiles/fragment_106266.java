Timer timer = new Timer(50, new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        for (PipeObject pipe : pipes) {
            pipe.move();
        }
        repaint();
    }
});