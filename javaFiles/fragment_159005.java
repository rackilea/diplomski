package test;
import java.util.Arrays;

/**
 * A double[] that with by-value semantics for equals() and hashCode() so you
 * can use it in HashMaps.
 * In a non-toy class, you'd probably use switch statements to support arrays
 * of any primitive type. In a language with real generics, you'd just template
 * this.
 */
public class EqualByValueDoubleArray {
    private double[] x;
    public EqualByValueDoubleArray(double[] x) { this.x = x; }
    public double[] getArray() { return x; };
    public boolean equals(Object obj) {
        if (obj instanceof EqualByValueDoubleArray) {
            return Arrays.equals(this.x, ((EqualByValueDoubleArray)obj).x);
        } else {
            return false;
        }
    }
    public int hashCode() { return Arrays.hashCode(x); }
}