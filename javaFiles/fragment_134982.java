public class CartesianCoordinate {
    private long xCoordinate;
    private long yCoordinate;

    public CartesianCoordinate(long xCoordinate,long yCoordinate) {
        this.xCoordinate=xCoordinate;
        this.yCoordinate=yCoordinate;
    }

    public long getXCoordinate() {
        return xCoordinate;
    }

    public long getYCoordinate() {
        return yCoordinate;
    }

    public void moveCoordinateByStepSize(Direction direction,long stepSize) {
        xCoordinate+=direction.x*stepSize;
        yCoordinate+=direction.y*stepSize;
    }

    @Override
    public int hashCode() {
        int hashCode=0;
        hashCode += (int)(xCoordinate-yCoordinate)*31;
        hashCode += (int)(yCoordinate+xCoordinate)*17;
        return hashCode;
    }

    @Override
    public boolean equals(Object object) {
        if(object == null || !(object instanceof CartesianCoordinate)) {
            return false;
        }
        if( this == object) {
            return true;
        }
        CartesianCoordinate cartesianCoordinateObject = (CartesianCoordinate)object;
        if(xCoordinate == cartesianCoordinateObject.getXCoordinate() && yCoordinate == cartesianCoordinateObject.getYCoordinate()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "["+xCoordinate+","+yCoordinate+"]";
    }

    public CartesianCoordinate getAClone() {
       return new CartesianCoordinate(xCoordinate,yCoordinate);
    }
}