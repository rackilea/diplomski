@Override
public boolean equals(Object o){
    if(!(o instanceof Coordinate)) {
        return false;
    }
    Coordinate c = (Coordinate)o;
    return (this.x == c.getxCoordinate() && this.y == c.getyCoordinate());
    }