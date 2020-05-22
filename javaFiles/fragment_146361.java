public class Tester {

    public static void main(String[] args) {
        Rotation tester = Rotation.CW0;
        System.out.println(tester.next());
    }
}

public enum Rotation {

    CW0, CW90, CW180, CW270;

    public Rotation next() {
        switch (this) {
        case CW0:
           return CW90;
        case CW90:
           return CW180;
        case CW180:
           return CW270;
        case CW270:
           return CW0;
        }
        return null;
    }
}