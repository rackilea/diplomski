import java.util.HashMap;
import java.util.Map;

/**
 * Created by arunavs on 9/28/16.
 */
public class Polynomial {

    // Key is power, value is coeff.
    private Map<Integer, Integer> powerToCoeffMap = new HashMap<>();

    // Maximal power allowed for polynomial.
    private int maxPower;


    public Polynomial(int maxPower){
        this.maxPower = maxPower;
    }

    public void setTerm(int coefficient, int power) {
        if (power > maxPower) {
           // throw some exception here. 
        }
        powerToCoeffMap.put(power, coefficient);
    }

    // terms may be rearranged in output. 
    public String toString() {
        StringBuilder builder = new StringBuilder();
        powerToCoeffMap.forEach((power, coeff) -> {builder.append(coeff + "x^" + power+ " ");});
        return builder.toString();
     }

        public static void main(String args[]) {
            Polynomial q = new Polynomial(2);
            q.setTerm(2, 0);
            q.setTerm(0, 1);
            q.setTerm(3, 2);
        System.out.println(q);
    }
}