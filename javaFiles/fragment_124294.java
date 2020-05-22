public class Javanotes {

    static int length [];

    public static void main(String[] args) {            
        System.out.println(arraylistExample()); // print 3
        System.out.println(length[5]); // print 8
    }

    public static int arraylistExample() {
        length = new int [10]; // init the static field

        length[0] = 2;
        length[1] = 3;
        length[5] = 8;  

        return length [1];
    }
}