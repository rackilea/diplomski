int n = Integer.parseInt(
    JOptionPane.showInputDialog("How many integers do you want in your list?"));
List<Integer> inputs = new ArrayList<Integer>(n);
for (int i = 0; i < n; ++i) {
  inputs.add(Integer.parseInt(
      JOptionPane.showInputDialog("Enter an integer:")));
}
int largest = Collections.max(inputs);
JOptionPane.showMessageDialog(null, "The largest number is: " + largest);