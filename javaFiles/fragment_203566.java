public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    while (true) {
        System.out.print("Enter a box type, basic or diagonal: ");
        String g = input.nextLine();
        if (!(g.equals("basic") || g.equals("diagonal"))) {
            continue;
        }

        System.out.print("Enter a number between 2 - 16: ");
        try {
            int boxSize = Integer.parseInt(input.nextLine());
            if (boxSize >= 2 && boxSize <= 16) {
            for (int i = 0; i <boxSize; i++) {
                for (int j = 0; j < boxSize; j++) {
                    if (i == j && g.equals("diagonal")) {
                        System.out.print("*");
                    } else if (i == 0 || i == boxSize-1) {
                        System.out.print("*");
                    } else if (j == 0 || j == boxSize-1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } catch(Exception e){
                System.out.println("RESETTING. Please type an integer this time.");
        }

        System.out.print("Make another square? Type yes or no: ");
        if (input.nextLine().equals("no")) {
            System.out.print("Thanks for playing!");
            System.exit(0);
        }
    }
}