String[] letters = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}; 
for (int i = 0 ; i <= 10 ; i++){
    for (int j = 0 ; j <= 10 ; j++){
        if (i == 0) {
            System.out.print(letters[j]);
        } else if (j == 0){
            System.out.print(letters[i]);
        } else {
            System.out.print("-");
        }           
        System.out.print(" ");
    }
    System.out.println();
}