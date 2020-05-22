public class AnimationTester1
{
    public static void main(String[] args)
    {        
       AnimationGraphics animate = new AnimationGraphics();

       Animation animation = new Animation();
       animation.drawLine(myrtle, x1, y1, x2, y2);
       animation.prepareTurtleToDraw(myrtle, color, x, y);
       animation.pressC();
       Animation.animation();

    }    
}