public interface MyDrawable {

    /**
     *  Draw this object on the "processing" canvas
     *  note: 2rs2ts does not know anything about the "processing" library
     */
    public void draw();

}

// another file...

public class Connector implements MyDrawable {

    // all of the other stuff

    public void draw() {
        stroke(lineColor);
        // etc.
    }
}