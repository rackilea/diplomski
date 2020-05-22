import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class YingYang extends Area
{
    AffineTransform at = new AffineTransform();
    private boolean movingRight = true;
    private boolean movingUp = true;
    private Color color = Color.BLACK;
    private int dx = 10, dy = 10;

    public YingYang(Shape shape)
    {
        super(shape);
    }


    public YingYang()
    {

        // Construct the Outer Circle & Lower Dot
        Area mainCircle = new Area(new Ellipse2D.Double(-210, -210, 420, 420));
        Area lowerDot = new Area(new Ellipse2D.Double(-10, 90, 40, 40));
        mainCircle.subtract(lowerDot);

        // Begin Construction of the whit side of symbol
        Area whiteSide = new Area(new Ellipse2D.Double(-200, -200, 400, 400));
        Area rect = new Area(new Rectangle2D.Double(0, -200, 200, 400));
        whiteSide.subtract(rect);

        // Construct the upper white Circle
        Area upperCircle = new Area(new Ellipse2D.Double(-100, -200, 200, 200));
        whiteSide.add(upperCircle);

        // Construct the Upper Dot
        Area upperDot = new Area(new Ellipse2D.Double(-10, -110, 40, 40));
        whiteSide.subtract(upperDot);

        // Remove the lower circle portion
        Area lowerCircle = new Area(new Ellipse2D.Double(-100, 0, 200, 200));
        whiteSide.subtract(lowerCircle);


        // Add Main Circle
        add(mainCircle);
        // Subtract the white side
        subtract(whiteSide);

    }

    //------------------------ Methods -----------------------------------------

    /**
     * Sets this shapes color
     * (must call getColor before drawing this shape)
     * @param color
     */
    public void setColor(Color color)
    {
        this.color = color;
    }

    /**
     * Gets this shapes current color
     * @return color
     */
    public Color getColor()
    {
        return this.color;
    }

    /**
     * Determines if the shape is moving left to right
     * @return - boolean
     */
    public boolean isMovingRight()
    {
        return movingRight;
    }

    /**
     * Determines if the shape is moving from down to up
     * @return - boolean
     */
    public boolean isMovingUp()
    {
        return movingUp;
    }

    /**
     * Changes the Horizontal Path that this shape is traveling
     */
    public void changeHorizonalMovement()
    {
        if(isMovingRight())
        {
            movingRight = false;
        }
        else
        {
            movingRight = true;
        }
    }

    /**
     * Changes the Vertical Path that this shape is traveling
     */
    public void changeVerticalMovement()
    {
        if(isMovingUp())
        {
            movingUp = false;
        }
        else
        {
            movingUp = true;
        }
    }

    /**
     * Sets the direction of the Horizontal Path of this shape
     *  true = left to right : false = right to left
     * @param dir - boolean
     */
    public void setHorizonalMovement(boolean dir)
    {
        this.movingRight = dir;
    }

    /**
     * Sets the direction of the Vertical Path of this shape
     *  true = down to up : false = up to down
     * @param dir - boolean
     */
    public void setVerticalMovement(boolean dir){
        this.movingUp = dir;
    }

    /**
     * Moves the current shape by the amount x,y
     * @param x - double
     * @param y - double
     */
    public YingYang moveTo(double x, double y)
    {  

        at.translate(x, y);
        at.setToTranslation(x, y);
        transform(at);
        return new YingYang(at.createTransformedShape(this));
    }

    /**
     * Rotate this shape
     * @param theta - amount to rotate shape by
     * @return 
     */
    public YingYang rotate(double theta)
    {
        double cx = getBounds2D().getCenterX();
        double cy = getBounds2D().getCenterY();

        at.translate(cx, cy);
        at.setToTranslation(cx, cy);
        at.rotate(Math.toRadians(theta));
        at.translate(-cx, -cy);
        return new YingYang(at.createTransformedShape(this));
    }

    public YingYang moveToAndRotate(double x, double y, double theta)
    {
        double cx = getBounds2D().getCenterX();
        double cy = getBounds2D().getCenterY();

        at.translate(cx, cy);
        at.setToTranslation(cx, cy);
        at.translate(x, y);
        at.rotate(Math.toRadians(theta));
        at.translate(-cx, -cy);
        return new YingYang(at.createTransformedShape(this));
    }

    /**
     * Scales this shape uniformly by the amount of scale
     *   about the origin
     * @param scale - double
     */
    public YingYang scaleBy(double scale)
    {
        double cx = this.getBounds2D().getCenterX();
        double cy = this.getBounds2D().getCenterY();

        at.translate(cx, cy);
        at.setToTranslation(cx, cy);
        at.scale(scale, scale);      
        at.translate(-cx, -cy);
        return new YingYang(at.createTransformedShape(this));
    }

    /**
     * Rotates this shape theta degrees about the origin
     */
    public YingYang rotate(Double theta)
    {
        double cx = this.getBounds2D().getCenterX();
        double cy = this.getBounds2D().getCenterY();

        at.translate(cx, cy);
        at.setToTranslation(cx, cy);
        at.rotate(Math.toRadians(theta));      
        at.translate(-cx, -cy);
        return new YingYang(at.createTransformedShape(this));
    }

    public int getDx()
    {
        return this.dx;
    }

    public void setDx(int x)
    {
        this.dx = x;
    }

    public int getDy()
    {
        return this.dy;
    }

    public void setDy(int y)
    {
        this.dy = y;
    }

}