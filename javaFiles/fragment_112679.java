public static void number(int n) { // first n
    bottles = new Scanner(System.in);
    bottles.useDelimiter("\n");

        System.out.println("Enter the starting number of " 
                + "bottles in the song "
                + "'99 Bottles of Beer on the Wall':");
        int n = bottles.nextInt(); // second n