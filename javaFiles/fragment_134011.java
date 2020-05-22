Scanner sc = new Scanner(System.in);
char card1 = ' ';
char card2 = ' ';
int count = 0;
int globalCount = 0;
do {
    globalCount++;
    card1 = sc.nextLine().charAt(0);
    card2 = sc.nextLine().charAt(0);
    if (((card1 - '0' >= 2 && card1  - '0' <= 9) || card1 == 'T' || card1 == 'J' || card1 == 'Q' || card1 == 'K' || card1 == 'A') && ((card2 - '0' >= 2 && card2 - '0' <= 9) || card2 == 'T' || card2 == 'J' || card2 == 'Q' || card2 == 'K' || card2 == 'A')){
        if (card1 == 'A' || card1 == 'K' && card2 == 'A' || card2 == 'K') {
            count++;
        }else {
            count = 0;
        }
    }else {
        System.out.println("Invalid cards given!");

    }
}while (count < 3);
System.out.println("Number of tries: " + globalCount);