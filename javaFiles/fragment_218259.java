class Cosine {

    public final double result; //field holding the result

    //constructor
    public Cosine (double x){
     result = Math.cos(Math.toRadians(x)); //compute the result
   }
}

public class test {
    public static void main (String[] args){
        double x = 90;
        double cosX = new Cosine(x).result;
    }
}