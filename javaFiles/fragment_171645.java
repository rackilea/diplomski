class Coordinates {
    private double coorX, coorY;
}

public class Coordinates3D extends Coordinates {
    //current code...
    @Override
    public String toString() {
        //now you will get a compilaton error
        String myString = "(" + coorX + " , " + coorY + " , " + coorZ + ")" ;
        return myString;
    }
}