import java.util.Scanner;


public class Sort5 {

    static int a1 = Integer.MIN_VALUE, a2 = Integer.MIN_VALUE, a3 = Integer.MIN_VALUE, a4 = Integer.MIN_VALUE, a5 = Integer.MIN_VALUE;


    public static void placeNext(int aNew) {
        if (aNew > a5) {
            a1 = a2;
            a2 = a3;
            a3 = a4;
            a4 = a5;    
            a5 = aNew;
        } else {
            if (aNew > a4) {
                a1 = a2;
                a2 = a3;
                a3 = a4;
                a4 = aNew;
            } else {
                if (aNew > a3) {
                    a1 = a2;
                    a2 = a3;
                    a3 = aNew;
                } else {
                    if (aNew > a2) {
                        a1 = a2;
                        a2 = aNew;
                    } else {
                        a1 = aNew;
                    }
                }
            }
        }
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        placeNext(sc.nextInt());
        placeNext(sc.nextInt());
        placeNext(sc.nextInt());
        placeNext(sc.nextInt());
        placeNext(sc.nextInt());

        System.out.println("" + a1 + " | " + a2 + " | " + a3 + " | " + a4 + " | " + a5);
    }

}