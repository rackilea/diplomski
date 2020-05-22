public class Complex {
    private double real;
    private double imaginary;

    public static final Comparator<Complex> COMPARE_BY_REAL =
        Comparator.comparingDouble(Complex::getReal);

    public static final Comparator<Complex> COMPARE_BY_IMAGINARY =
        Comparator.comparingDouble(Complex::getImaginary);

    public static final Comparator<Complex> COMPARE_BY_MODULUS =
        Comparator.comparingDouble(Complex::getModulus);

    private double getModulus() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }
 }