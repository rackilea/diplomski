public class Rectangle {
    // DO NOT MODIFY THE INSTANCE VARIABLES
    // begin instance variables
    private int width;
    private int height;
    // end instance variables

    // TODO - write your code below this comment.
    // You need to do the following:
    //
    // 1.) Define a constructor which takes two ints
    //     representing the width and height, respectively.
    //     The constructor should set its instance variables
    //     equal to these values.
    //
    // 2.) Define a "getter" named getWidth, which returns
    //     the width of the rectangle.
    //
    // 3.) Define a "getter" named getHeight, which returns
    //     the height of the rectangle.
    //
    // 4.) Define a "setter" named setWidth, which takes
    //     the new width of the rectangle and sets the
    //     rectangle's width to that value.
    //
    // 5.) Define a "setter" named setHeight, which
    //     takes the new height of the rectangle and sets
    //     the rectangle's height to that value
    //
    // 6.) Define a toString method, which returns
    //     a String representation of the rectangle.
    //     As an example, if the width of the rectangle is
    //     3 and the height of the rectangle is 4, this should
    //     return the String:
    //
    //     "Rectangle(3, 4)"
    //
    public Rectangle(int rectWidth, int rectHeight) {
        // "this" refers to the instance of Rectangle you are creating
        // so this objects width and height are set to the values passed into the constructor...
        this.width = rectWidth;
        this.height = rectHeight;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void setWidth(int rectWidth) {
        width = rectWidth;
    }
    public void setheight(int rectHeight) {
        height = rectHeight;
    }
    public String toString() {
        // the toString returns a string representation for "this" object
        return "Rectangle(" + this.width + "," + this.height + ")";
    }
    public static void main(String[] args) {
        Rectangle s = new Rectangle(5,4);
                System.out.println(s);
    }
}