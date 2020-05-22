import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Lane {
    private Vector2 pos;
    private Rectangle rect;

    public Lane(float width, float height, float x, float y) {
    rect = new Rectangle();
    rect.width = width;
    rect.height = height;
    rect.x = x;
    rect.y = y;

    pos = new Vector2(x, y);
    }

    public Vector2 getPos(){
    return pos;
    }

    public Rectangle getRect() {
    return rect;
    }
}