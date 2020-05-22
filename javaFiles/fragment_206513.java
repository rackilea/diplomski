String word = "Sugar";
int length = word.length();
for (int number = 0; number < length; number++) {
    for (int inner = 0; inner < number; inner++) {
        System.out.print(word.charAt(inner));
    }
    System.out.println("");
}