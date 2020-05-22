List<Integer> a1 = new ArrayList<>();
for (int x = 1; x <= 20; x++) {
    a1.add(x);
}
Collections.shuffle(a1);
int input1 = Integer.parseInt(JOptionPane
        .showInputDialog("Enter the Card Number: "));
System.out.println(a1.contains(input1));