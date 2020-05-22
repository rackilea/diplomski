import processing.core.*;
import de.fhpotsdam.unfolding.*;
import de.fhpotsdam.unfolding.providers.Google;

public class LifeExpectancy extends PApplet {
    UnfoldingMap map;

    public void setup() {
        size(800, 600, OPENGL);
        map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
    }

    public void draw() {
        //draw your map
    }
}