import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class ObstacleHole {

Player player = new Player();
Random position = new Random();

int x;
int y;
int dx = 1;
int width = 100;
int height = 100;

public ObstacleHole(){
    x = getNewPosition();
    y = 250;
}

public void move(){
    x = x - player.playerSpeed;

    if(x < 0 - width) {
        x = getNewPosition();
    }
}

public void paint(Graphics g){
    g.setColor(Color.BLACK);
    g.fillRect(x, y, width, height);
}

public Rectangle bounds(){
    return (new Rectangle(x, y, width, height));
}

public int getX() {
    return x;
}

private int getNewPosition() {
    return 200 + position.nextInt(300);
}
}