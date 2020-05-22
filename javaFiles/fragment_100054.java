public static void main(String[] args) {
Scanner in = new Scanner(System.in);
boolean repeat;
List<Integer> digits = new ArrayList<Integer>();

do {
    repeat = false;
    System.out.print("Enter your Credit Card Number : ");
    String input = in.next();

    for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if (c < '0' || c > '9') {
            repeat = true;
            digits.clear();
            break;
        } else {
            digits.add(Integer.valueOf(c - '0'));
        }
    }
} while (repeat);

int[] array = new int[digits.size()];
for (int i = 0; i < array.length; i++) {
    array[i] = Integer.valueOf(digits.get(i));
}
boolean valid = check(array);
System.out.println("Valid: " + valid);