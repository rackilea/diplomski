int[] input = new int[]{1, 2, 2, 5, 5, 5, 1, 7, 3, 7, 7, 7};
int current = input[0];
boolean found = false;

for (int i = 0; i < input.length; i++) {
    if (current == input[i] && !found) {
        found = true;
    } else if (current != input[i]) {
        System.out.print(" " + current);
        current = input[i];
        found = false;
    }
}
System.out.print(" " + current); <--- you forgot this line