if (position != 0) {
    hidden[position - 1] = test;
}
for (int i = 0; i < secretWord.length(); i++) {
    System.out.print(hidden[i] + " ");
}