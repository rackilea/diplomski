public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Random generator = new Random();

        String tryAgain = "y";
        do {
            System.out.print("enter minimum of Yahtzee dice 2-9:");
            int min = input.nextInt();
            input.nextLine();
            System.out.print("enter maximum of Yahtzee dice 3-10:");
            int max = input.nextInt();
            input.nextLine();

            System.out.println("Dice   Rolls\tYahtzee's Percentage  Odds\t");

            for (int i = min; i <= max; i++) {
                int count = 0;
                boolean success = true;
                for (int j = 0; j <= 5000; j++) {
                    YahtzeeDice d = new YahtzeeDice(generator, i);
                    if (d.IsAYahtzee()) {
                        count++;
                    }
                }
                System.out.printf("%d     ", i);
                System.out.printf("%d\t", 5000000);
                System.out.printf("%d\t  ", count);
                System.out.printf("%f   ", (double) count / 5000000);
                double per = count / (double) 5000000;
                int odds = (int) (1 / per);
                System.out.printf("1 in %d\n", odds);
            }

            System.out.print("Run another simulation [y/n]? ");
            tryAgain = input.nextLine();

        } while (!tryAgain.equals("n"));

}