public class MultiDemPoint{
    private double[] coords;
    //double... coords will automatically convert all supplied coordinates to the array,
    // we can store it in double[] coords.
    public MultiDemPoint(double... coords){
        this.coords = coords;
    }

    public void printCoords(){
        for(int i=0; i<coords.length; i++){
            System.out.println("Coordinate #"+i+": "+coords[i]);
        }
        System.out.println("");
    }
}