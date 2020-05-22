String[] letters = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
for (int i = 0 ; i <= 10 ; i++){
    for (int j = 0 ; j <= 10 ; j++){
        System.out.print(i == 0 || j == 0 ? i == 0 ? letters[j] : letters[i] : "-");
        System.out.print(" ");
    }
    System.out.println();
}