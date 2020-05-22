public class Matematik {

    public static double volym(int tal){

        return round((4 * math.pi * math.pow(tal,3) / 3),2);

    }

    public static void main(String[] args) {

        System.out.println(volym(10));

    }
}