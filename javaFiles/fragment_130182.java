public class Ball extends AbstractBall {
    public Ball(int x_position, int y_position) {
        super(x_position, y_position);
    }

    public void move(int width, int height) {
        super.move(width, height);
        System.out.println("SUBTYPE-CLASS MOVE IS CALLED");
    }           

        public static void main(String[] args) {
                Ball ball = new Ball(10, 20);
                ball.move(1, 2);
        }
}

abstract class AbstractBall implements IMovable {

    protected int[] position = new int[2];
    protected int[] velocity = { 1, 1 };

    public AbstractBall(int x_position, int y_position) {
        position[0] = x_position;
        position[1] = y_position;
    }

    public void move(int width, int height) {

        System.out.println("BASE-CLASS MOVE IS CALLED");

        if (position[0] >  width - 30 || position[0] <  1) {
            velocity[0] *= -1;
        }
        if (position[1] > height - 30 || position[1] <  1) {
            velocity[1] *= -1;
        }
        position[0] += velocity[0];
        position[1] += velocity[1];
    }           
}

interface IMovable {
    public void move(int width, int height);
}