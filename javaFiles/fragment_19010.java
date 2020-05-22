protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("Paint");
        if (img != null) {
            System.out.println("draw");
            g.drawImage(img, 300, 300, this);
        }
        else
        g.clearRect(0, 0, getSize().width, getSize().height);
 }