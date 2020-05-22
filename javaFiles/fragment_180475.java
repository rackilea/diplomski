public class Ground extends Actor {
    public GreenfootImage getImage(){
        GreenfootImage image = new GreenfootImage(100, 100);
        image.setColor(Color.BLUE);
        image.fillRect(0, 0, 100, 100);
        return image;
    }
}