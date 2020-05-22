public Vector {
    private int x;
    private int y;

    public double distanceFrom( Vector here ) {
        return Math.sqrt( Math.pow(x - here.x, 2) + Math.pow( y - here.y,2) );
    }
}

public class Waypoint {
    Vector position;
    List<Waypoint> neighbors;

    public Waypoint( Vector pos, List<Waypoint> neighbors ) {
        this.position = pos;
        this.neighbors = neighbors;
    }

    public List<Waypoint> getNeighbors() {
        return neighbors;
    }

    public double h( Vector goal ) {
        return goal.distanceFrom( position );
    }

    public double g( Vector current ) {
        return position.distanceFrom( current );
    }

    public double f( Version current, Vector goal ) {
        return g(current) + h(goal);
    }
}