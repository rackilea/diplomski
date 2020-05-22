public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String a = "Stone";
        String b = "Scissors";
        String c = "Paper";
        //a > b
        //b > c
        //c > a
            String answer = "";
        do {
            System.out.println("Player one choose:");

            String x = in.nextLine();

            System.out.println("Player two choose:");

            String y = in.nextLine();

            answer = "";

            if ((x.equalsIgnoreCase(a) && (y.equalsIgnoreCase(b)))) {
                System.out.println("Player one won");
            } else if ((x.equalsIgnoreCase(b) && (y.equalsIgnoreCase(c)))) {
                System.out.println("Player one won");
            } else if ((x.equalsIgnoreCase(c) && (y.equalsIgnoreCase(a)))) {
                System.out.println("Player one won");
            } else {
                System.out.println("Player two won");
            }
            System.out.println("Do you want to play again? YES / NO");
            answer= in.nextLine();
        }

        while (answer.equalsIgnoreCase("YES"));
        if (answer.equalsIgnoreCase("NO")){
            System.out.println("Goodbye!");
        }
    }