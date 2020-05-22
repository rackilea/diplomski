public class Degree {

    private Integer degrees;

    // Constructor, takes an Integer object or int primitive
    public Degree(Integer deg){
        setDegrees(deg);
    }
    // Get degrees from your wrapper object
    public Integer getDegrees(){
        return degrees;
    }
    // Set degress of your wrapper object
    public void setDegrees(Integer deg){
        if(deg<361 && deg>-1){ degrees = deg; }
        else if(deg>360){ degrees = 360; }
        else if(deg<0){ degrees = 0; }
    }
}