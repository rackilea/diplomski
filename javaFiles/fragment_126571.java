public class Cplx {
    private double realPart, imagPart;

    public Cplx(double r, double i) {
        realPart = r;
        imagPart = i;
    }

    public String toString() {
        if (imagPart == 0)
            return String.valueOf(realPart);

        if (realPart == 0)
            return String.valueOf(imagPart) + "i";

        return realPart + "+" + imagPart + "i";
    }

    public static void main(String[] args) {
        Cplx n;
        n = new Cplx(0,0); System.out.println(n);
        n = new Cplx(1,0); System.out.println(n);
        n = new Cplx(0,2); System.out.println(n);
        n = new Cplx(1,2); System.out.println(n);
    }
}