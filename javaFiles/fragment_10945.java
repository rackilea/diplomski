// Another way to share this state would be via a Point interface and 
// aggregating two point objects in your Item and Character classes
interface Coordinates {

    double getX1();

    double getY1();

    double getX2();

    double getY2();

}

interface Dimension {

    double getWidth();

    double getHeight();

}