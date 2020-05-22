1. Create a method "getPreferredSize()" in the "FirstClass". Declare and
initialize two private variables namely "width" and "height":

public class FirstClass extends Applet {
    private int width = 400;
    private int height = 300;
    ...
    @Override
    public void Dimension getPreferredSize() {
        return new Dimension(width,height);
    }
    ...

2. Or you can directly return the preferred width as:

    ...
    public int getPreferredWidth() {
        return width;
        // OR:
        // return (int)getPreferredSize().getWidth();
    } //and the same for height