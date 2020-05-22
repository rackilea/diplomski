public class EFrog {
    public static void main(String[] args) {
        Frog f = new Frog();
        f.go();
        f.come();
        Amphibian a = f;
        a.come();//this won't compile
    }
}