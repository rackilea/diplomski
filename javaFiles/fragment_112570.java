public class Player extends PhysicsObject{
    public static final double JUMP_STRENGTH = 5;
    public static final double SPEED = 1;
    public void jump() {
        accelerate(0, JUMP_STRENGTH); // change 5 for some constant or variable indicating the "strength" of the jump
    }

    public void runRight() {
        move(SPEED, 0);
    }

    public void runLeft() {
        move(-SPEED, 0);
    }
}