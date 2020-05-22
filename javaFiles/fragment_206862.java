public static void main(String[] args) {
    String holder = "", s;
    int size;

    s = JOptionPane.showInputDialog("Enter the size of the array");
    size = Integer.parseInt(s);
    String array1[] = new String[size]; //declared and instantiated array1

    for (int x = 0; x <= array1.length - 1; x++) {
        String num = JOptionPane.showInputDialog("Enter value for array[" + x + "]");

        if (Arrays.asList(array1).contains(num)) {
            x = x - 1;
            JOptionPane.showMessageDialog(null, "exists");
        } else {
            array1[x] = num;
            JOptionPane.showMessageDialog(null, "continue");
        }
    }

    for (int x = 0; x <= array1.length - 1; x++) {
        holder = holder + "\n" + array1[x];
    }

    JOptionPane.showMessageDialog(null, holder);
}