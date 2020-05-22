int sum = 0;
List<Integer> al = new ArrayList<>();
for (int i = 300; i >= 200; i--) {
    if ((i % 11 == 0) ^ (i % 13) == 0) {
        al.add(i);
        sum += i;
    }
}
for (int i = 0; i < al.size(); i++) {
    System.out.printf("%-8d", al.get(i));
    if ((i + 1) % 5 == 0) {
        System.out.println();
    }
}
System.out.printf("Found %d multiples, with a sum of %d.%n", al.size(), sum);