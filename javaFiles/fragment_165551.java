package Test;

public class Fetch {



    public Fetch() {

        System.out.println("Fetched!"); 

        int a = 1;
        int b = 2;
        int c;

        while (a < 100 && b < 200) {

            a++;
            b++;
            c = a + b;
            System.out.println(c);
        }
    }//<---- NOTE: closing constructor


    public void more(int d, int e) {

        System.out.println(d + e);


    }

}