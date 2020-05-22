public class Q2 {

    public static int sumDig(String digits) {

        int sum = 0;

        if (! digits.isEmpty()) {
            sum += Character.getNumericValue(digits.charAt(0)) + sumDig(digits.substring(1));
        }

        return sum;
    } 

    public static void main(String[] args) { 
        System.out.println(sumDig(args[0]));
    }
}