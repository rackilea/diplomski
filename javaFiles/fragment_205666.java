import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.jscience.mathematics.function.Polynomial;
import org.jscience.mathematics.function.Term;
import org.jscience.mathematics.function.Variable;
import org.jscience.mathematics.number.Integer64;

/** @see http://stackoverflow.com/questions/8276150 */
public class ReadPoly {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("test.txt"));
        String s;
        while ((s = r.readLine()) != null) {
            System.out.println("Coefficient: " + s);
            Polynomial<Integer64> p = create(s.split(" "));
            System.out.println("Polynomial:  " + p);
        }
    }

    public static Polynomial<Integer64> create(String... a) {
        Variable<Integer64> x = new Variable.Local<Integer64>("x");
        Polynomial<Integer64> px = Polynomial.valueOf(Integer64.ZERO, x);
        for (int i = 0, e = a.length - 1; i < a.length; i++, e--) {
            px = px.plus(Polynomial.valueOf(
                Integer64.valueOf(a[i]), Term.valueOf(x, e)));
        }
        return px;
    }
}