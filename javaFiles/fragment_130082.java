public class ArithmeticGame {

    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= 3; i++) {
            numbers.add(i);
        }
        char[] operations = { '*', '+' };
        permutateSigns(operations, numbers, 0, "");
    }

    public static void permutateSigns(char[] operations, LinkedList<Integer> numbers, int pos, String expression) {
        expression += numbers.get(pos);
        if (pos == numbers.size() - 1) {
            System.out.println(expression);
        } else {
            for (char operation : operations) {
                permutateSigns(operations, numbers, pos + 1, expression + operation);
            }
        }
    }
}