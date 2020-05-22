public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float f = 0;
        int x = 1;
        do {
            try {
                System.out.print("Enter an float:");
                f = in.nextFloat();
                x = 2;

            } catch (InputMismatchException e) {
                System.err.println("Incorrect entry.");
                in.next();

            }

        } while (x == 1);
        System.out.println("Your entry is:" + f);

    }