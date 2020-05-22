private boolean make = false;
private HashMap<Boolean, Point> points = new HaspMap<>();

makeButton.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent){
        make = true;
    }
});

missButton.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent){
        make = false;
    }
});

courtPanel.addMouseListener(new MouseAdapter(){
    public void mouseClicked(MouseEvent e){
        if (make) {
            points.put(true, e.getLocationOnScreen());
            repaint();   
        } else {
            points.put(false, e.getLocationOnScreen());
            repaint();
        }

});

protected void paintComponent(Graphics g){
    super.paintComponent(g);

    for (Map.Entry<Boolean, Point> entry : points.entrySet()) {
        Boolean key = entry.getKey();
        Point point = entry.getValue();

        if (key) {
            g.grawOval(point.getX(), point.getY(), 10, 20);
        } esle {
            g.drawLine(.., .., .., ..);  //draws one half of `X`
            g.drawLine(.., .., .., ..);  //draws other half
        }
    }
}