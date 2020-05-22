public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter a number:");
        int number = kb.nextInt();
        kb.close();
        char letter = 'X';
        int sqnumber = number * number;
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.print(letter);
            }
            System.out.println();
        }
    }