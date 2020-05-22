public static void main(String[] args) {

    int num = 1;

    Scanner input = new Scanner(System.in);
    do {
        System.out.println("Enter a 2-digit number. The digits should be different. zero to stop");
        if (!input.hasNextInt()) {
            System.out.println("Not an integer,try again " + num);
        } else {
            num = input.nextInt();
            if (num < 10 || num >= 99) {
                System.out.println("NOT good for your game! " + num);
            } else {
                System.out.println("Good for your game! Play! " + num);
            }
        }
    } while(num != 0);

    input.close();
    System.out.println("game stop");
}