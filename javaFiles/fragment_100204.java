import android.graphics.*;

public class AniSprite {

public RectF target;
public Rect source;
public Bitmap bitmap;
public int width;
public int height;
public float posx;
public float posy;
public int frames;
public int curframe = 0;

public AniSprite(Bitmap bitmap, float posx, float posy, int width, int height, int frames) {
    this.drawview = drawview;
    this.bitmap = bitmap;
    this.width = width;
    this.height = height;
    this.posx = posx;
    this.posy = posy;
    this.frames = frames;
    source = new Rect(curframe * width, 0, (curframe * width) + width, height);
    target = new RectF(posx, posy, posx + (width), posy + (height));
}

public void animate() {
    curframe++;
    if(curframe >= frames){
        curframe = 0;
    }
    source = new Rect(curframe, 0, (curframe) + width, height);
}

public void setSourceRect(Rect rect) {
    source = rect;
    curframe = rect.right/width;
}

public void ChangePos(float posx, float posy) {
    this.posx = posx;
    this.posy = posy;
    source = new Rect(curframe * width, 0, (curframe * width) + width, height);
    target = new RectF(posx, posy, posx + (width), posy + (height));
}

}