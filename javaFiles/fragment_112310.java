class Dog{

    private ImageIcon image;

    public Dog(){
        java.net.URL imgUrl = getClass().getResource("dog.jpg");
        image= new ImageIcon(imgUrl);
    }

    public void draw(Graphics g){
        g.drawImage(image.getImage(), x, y, width, height, null);
    }

}