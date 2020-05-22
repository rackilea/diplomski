public class AClasse {
    String a;

    public AClasse(String a) {
        this.a = a;
    }

    public static void main(String[] args) {
        AClasse[] clases = new AClasse[10];
        // clases[0].a = "?"; // the exception is in this line

        System.out.println(clases[0]);

        // Do it as follows
        clases[0] = new AClasse("?");
    }
}