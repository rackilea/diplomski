public class FractionTranslateLinearLayout extends LinearLayout{

    private int screenWidth;
    private float fractionX;

    protected void onSizeChanged(int w, int h, int oldW, int oldh){

        // Assign the actual screen width to our class variable.
        screenWidth = w;            

        super.onSizeChanged(w, h, oldW, oldH);
    }

    public float getFractionX(){

        return fractionX;
    }

    public void setFractionX(float xFraction){

        this.fractionX = xFraction;

        // When we modify the xFraction, we want to adjust the x translation
        // accordingly.  Here, the scale is that if xFraction is -1, then
        // the layout is off screen to the left, if xFraction is 0, then the 
        // layout is exactly on the screen, and if xFraction is 1, then the 
        // layout is completely offscreen to the right.
        setX((screenWidth > 0) ? (xFraction * screenWidth) : 0);
    }
}