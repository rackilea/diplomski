public class Triplet <T> {
    public T a, b, c;

    Triplet(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args) {
        Triplet<String> triplet = new Triplet<String>("Hello", "Guten Tag", "Bonjour");
        printPartsOfTriplet(triplet);
    }

    static void printPartsOfTriplet(Triplet<?> triplet) {
       System.out.println(triplet.a);
       System.out.println(triplet.b);
       System.out.println(triplet.c);
    }



}