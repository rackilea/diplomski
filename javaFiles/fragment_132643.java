class Polygon {

    float height;
    float width;
    float length;

    public Polygon(int h, int w, int l) {
        height = h;
        width = w;
        length = l;
    }
}

class Coordinate {

    float x; 
    float y;

    public Coordinate() {}

    public Coordinate(float xCoord, float yCoord) {
        x = xCoord;
        y = yCoord;
    }
}

class Transform {

    float rotate;
    float speed;

    public Transform(float r, float s) {
        rotate = r;
        speed = s;
    }
}