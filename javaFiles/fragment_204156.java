List<Character> sequence = new ArrayList<>();
for (char c = 'A' ; c <= 'Z' ; c++) {
    sequence.add(c);
}
Collections.shuffle(sequence);
for (Character c : sequence) {
    System.out.print(c);
}