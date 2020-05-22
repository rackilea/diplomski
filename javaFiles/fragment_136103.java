public void go(){
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    MyDrawPanel panel = new MyDrawPanel(x, y, height, width);

    frame.getContentPane().add(panel);
    frame.setSize(height,width);
    frame.setVisible(true);

    for(int i = 0; i < 100; i++){
        x++;
        y++;
        panel.repaint();

        try{
            Thread.sleep(50);
        } catch(Exception ex){}
    }
}