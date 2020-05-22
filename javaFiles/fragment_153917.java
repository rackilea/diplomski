public class Q2Circles extends JPanel {

    // this allows the user to specify how many loops of recursion they want the programme to complete before finishing
    int recursionsToDo;

    public Q2Circles(int recursionMax){
        super();
        recursionsToDo = recursionMax;
    }

    /*
        this method is automatically called when we run the constructor as it inherits from the JFram superclass. here
        we are setting out the size of the circle by getting the size of the window to make it proportional to the rest
        of the screen and circles.
        we then pass these values into the drawCircle method to draw the circle
     */
    public void paintComponent(Graphics g){
        Rectangle rectangle = this.getBounds();
        int diameter = rectangle.width/3;
        int centerPoint = rectangle.width/2;

        drawCircle(g, 1, centerPoint, diameter);

    }

    /*
        This method is where the magic of the programme really takes place. first of all we make sure we haven't completed
        the necessary recursions. we the set the color by dividing it by the amount of times we have recursed, this will
        have the affect of getting darker the more times the method recurses. we then sset the color. finaly we fill the
        oval (draw the circle). because we want to move depending on the times it has recursed and size of the previous
        we do it based on the size of the elements from the previous call to this method. Getting the right numbers
        though was just alot of trial and error.

        we then increment the recursion counter so that we know how many times we have recursed and that can then be
        used at different points where needed. e.g for setting the color.

        each recursive call used the dimension of the other recursive calls to make the whole picture. Although the
        first recursive call creates the circles on the right of the screen. the second call draws the circle on the
        left of the screen and the last one does the circles in the middle, they all use eachothers values to make it
        complete. without one recursive step, more is missing than just what is created by that recursive call on its own.

        in all honesty though, there is alot of duplication, like the large middlecircle.


     */
    public void drawCircle(Graphics g, int amountOfRecursions, int center, int diameter){
        if (amountOfRecursions <= recursionsToDo){
            int recursionsCount = amountOfRecursions;

            int greenColor = Math.round(225 / (amountOfRecursions));
            g.setColor(new Color(0,  greenColor, 0));
            g.fillOval(center - (diameter/2), 200 - (diameter/2), diameter, diameter);

            recursionsCount++;

            drawCircle(g, recursionsCount, Math.round(center + diameter), diameter/3);
            drawCircle(g, recursionsCount, Math.round(center - diameter), diameter/3);
            drawCircle(g, recursionsCount, Math.round(center), diameter/3);

        }
    }}