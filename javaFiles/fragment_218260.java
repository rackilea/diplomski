public static double getCosine(double x) {
    return Math.cos(Math.toRadians(x));
}

public class test {
    public static void main (String[] args){
        double x = 90;
        double cosX = getCosine(x);
    }
}