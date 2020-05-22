public static void main(String[] args) {
List<Integer> numbersA = new ArrayList<>();
List<Integer> numbersB = new ArrayList<>();
numbersA.addAll(Arrays.asList(new Integer[] { 1, 3, 4, 7, 5, 2 }));
numbersB.addAll(Arrays.asList(new Integer[] { 13, 32, 533, 3, 4, 2 }));
System.out.println("A: " + numbersA);
System.out.println("B: " + numbersB);

numbersB.removeAll(numbersA);
System.out.println("B cleared: " + numbersB);
}