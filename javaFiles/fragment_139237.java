public class TestNumber {

    private final static List<String> numbers = new ArrayList<>();
    private final static List<String> words = new ArrayList<>();

    public static void main(String args[]) {
        long start, end;
        Random random = new Random();

        for (int i = 0; i < 1000000; i++) {
            numbers.add(String.valueOf(i));
            words.add(String.valueOf(i) + "x");
        }

        for (int i = 0; i < 5; i++) {
            start = System.nanoTime();
            regex(numbers);
            System.out.println("regex with numbers " + (System.nanoTime() - start) / 1000000);
            start = System.nanoTime();
            chars(numbers);
            System.out.println("chars with numbers " + (System.nanoTime() - start) / 1000000);
            start = System.nanoTime();
            exception(numbers);
            System.out.println("exceptions with numbers " + (System.nanoTime() - start) / 1000000);

            start = System.nanoTime();
            regex(words);
            System.out.println("regex with words " + (System.nanoTime() - start) / 1000000);
            start = System.nanoTime();
            chars(words);
            System.out.println("chars with words " + (System.nanoTime() - start) / 1000000);
            start = System.nanoTime();
            exception(words);
            System.out.println("exceptions with words " + (System.nanoTime() - start) / 1000000);
        }
    }

    private static int regex(List<String> list) {
        int sum = 0;
        Pattern p = Pattern.compile("[0-9]+");
        for (String s : list) {
            sum += (p.matcher(s).matches() ? 1 : 0);
        }
        return sum;
    }

    private static int chars(List<String> list) {
        int sum = 0;

        for (String s : list) {
            boolean isNumber = true;
            for (char c : s.toCharArray()) {
                if (c < '0' || c > '9') {
                    isNumber = false;
                    break;
                }
            }
            if (isNumber) {
                sum++;
            }
        }
        return sum;
    }

    private static int exception(List<String> list) {
        int sum = 0;

        for (String s : list) {
            try {
                Integer.parseInt(s);
                sum++;
            } catch (NumberFormatException e) {
            }
        }
        return sum;
    }
}