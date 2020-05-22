int x, y;
Timer timer = new Timer(50, new ActionListener(){

    public void actionPerformed(ActionEvent evt){
        // update x and y 

        repaint();
    }
});