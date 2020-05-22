public GameVector[] getVertices(GameObject obj){
    final GameVector topLeft = new GameVector( obj.mPosition.x-0.06f - (obj.mWidth/2), obj.mPosition.y+0.06f +(obj.mHeight/2) );
    final GameVector topRight = new GameVector(   obj.mPosition.x+0.06f + (obj.mWidth/2),obj.mPosition.y+0.06f +(obj.mHeight/2) );
    final GameVector bottomLeft = new GameVector(  obj.mPosition.x-0.06f - (obj.mWidth/2), obj.mPosition.y-0.06f -(obj.mHeight/2));
    final GameVector bottomRight = new GameVector(  obj.mPosition.x+0.06f + (obj.mWidth/2), obj.mPosition.y-0.06f -(obj.mHeight/2));

    //order here matters
    GameVector[] vertices = { topLeft, topRight, bottomRight, bottomLeft }; 
    return vertices;
}

public GameVector[] getAxis(GameObject shape){

    GameVector[] vertices = getVertices(shape);

    GameVector[] axes = new GameVector[vertices.length];
    // loop over the vertices
    for (int i = 0; i < vertices.length; i++) {
        // get the current vertex
        GameVector p1 = vertices[i];
        // get the next vertex if i+1 == vertices length set back to vertices [0]
        GameVector p2 = vertices[i + 1 == vertices.length ? 0 : i + 1];
        // subtract the two to get the edge vector
        GameVector edge = p1.subtract(p2.x, p2.y);
        // get either perpendicular vector
        GameVector normal;
        //get the left side normal of the vector due to clock wise positions
        normal = new GameVector(edge.y, -edge.x);//edge.perp();
        axes[i] = normal;
    }
    return axes;
}

public float dotProduct(GameVector a, GameVector b){
    float dp = a.x*b.x + a.y*b.y;
    return dp;
}

public class Projection {

    private final float min;
    private final float max;

    public Projection(float min, float max) {
        this.min = min;
        this.max = max;
    }

    public boolean doesOverlap(final Projection other) {
        return !(this.min > other.max || other.min > this.max);

    }
}