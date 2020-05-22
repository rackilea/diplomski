import java.util.Random;

public class opgave6 {
    public static Verzameling a = new Verzameling(20, 3);
    public static Verzameling b = new Verzameling(20, 4);

    public static void main(String[] args) {
        System.out.println("before something");
        System.out.println(Verzameling.deelverzamelingVan());
        System.out.println("after something");
    }
}


class Verzameling {
    int[] elementen;
    int elementen2;
    static int aantal2;

    Verzameling(int aantal, int seed) {
        elementen = new int[100];
        int aantal2 = aantal;

        for (int i = 0; i < 100; i++) {
            elementen[i] = i;
        }

        Random random1 = new Random(seed);

        for (int i = 0; i < 100; i++) {
            int r = random1.nextInt(100);
            int temp;
            temp = elementen[i];
            elementen[i] = elementen[r];
            elementen[r] = temp;
        }

        printVerzameling(aantal);
    }

    // you arent using it -- do so or delete it
    Verzameling(int seed) {
    }

    void printVerzameling(int aantal) {
        for (int i = 0; i < aantal; i++) {
            System.out.print(elementen[i] + " ");
        }
        System.out.println();
    }

    static boolean deelverzamelingVan() {
        for (int i = 0; i < aantal2; i++) {
            for (int j = 0; j < aantal2; j++) {
                int aElementen = opgave6.a.elementen[i];
                int bElementen = opgave6.b.elementen[j];
                System.out.println(String.format("Comparing a[i] to b[i] [%d, %d]", aElementen, bElementen));
                if (aElementen == bElementen)
                    break;
            }
        }

        // need to return something, i dont know what.
        return true;
    }


}