public static void main(String[] args) {
   String string = JOptionPane.showInputDialog(null, "Please input a string");
   String reversed = reverse(string);
   showMessageDialog(null, reversed); 
}

private static String reverse(String forward) {
    char[] x = forward.toCharArray();
    String reversed = "";
    for(int i = x.length-1; i >= 0; --i) {
        reversed += x[i];
    }
    return reversed;
}