public class RegionSelectorListener extends MouseAdapter {
    final JLabel label;

    public RegionSelectorListener(JLabel theLabel) {
        this.label = theLabel;
        theLabel.addMouseListener(this);
    }

    Point origin = null;

    public void mouseClicked(MouseEvent event) {
        if (origin == null) { //If the first corner is not set...

            origin = event.getPoint(); //set it.

        } else { //if the first corner is already set...

            //calculate width/height substracting from origin
            int width = event.getX() - origin.x;
            int height = event.getY() - origin.y;

            //output the results (replace this)
            System.out.println("Selected X is: "+ origin.x);
            System.out.println("Selected Y is: "+ origin.y);
            System.out.println("Selected width is: "+ width);
            System.out.println("Selected height is: "+ height);
        }
    }
}