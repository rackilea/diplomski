public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    System.out.print("How many dice do you want to roll?");
    int D6 = scan.nextInt();

    System.out.print("What would you like your offset to be?");
    int offset = scan.nextInt();

    int total = 0;

    for(int i=0 ; i<D6 ; i++){
        int number = rand.nextInt(6) + 1;
        System.out.println("Rolled " + number);
        total += number;
    }

    total = total + offset;

    System.out.print("The result of rolling " + D6 + "D6+" + offset + " is " + total);

}