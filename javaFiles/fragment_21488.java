public class Gold extends Sprite {
    private boolean isCollected; //only use a primitive wrapper if you really need one

    public Gold(Rectangle bounds, Texture gold) {
        super(gold);

        setSize( bounds.width / MarioBros.PPM, bounds.height / MarioBros.PPM);
        setPosition(bounds.x / MarioBros.PPM, bounds.y / MarioBros.PPM);
        isCollected = false;
    }
//...
}