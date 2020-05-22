public class RainFall implements Comparable<RainFall> {

    double amount;
    // your code

    public int compareTo(RainFall r) {
        return Double.compare(this.amount, r.amount); 
    }

}