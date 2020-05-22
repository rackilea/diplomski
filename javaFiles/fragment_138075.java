public class Test {
    public static void main(String[] args) {
        int num = 83491;

        if (num < 0)
            num = -num;
        List<Integer> digits = new LinkedList<Integer>();

        while (num > 0) {
            digits.add(0, num % 10);
            num = num / 10;
        }

        System.out.println(Arrays.toString(digits.toArray()));
    }
}