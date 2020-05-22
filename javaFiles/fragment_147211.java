public static void processSales() {

    Scanner scanFile = null;
    Scanner keyboard = new Scanner(System.in);

    while (scanFile == null) {

        System.out.println("Enter sales file name: ");
        String salesFile = keyboard.nextLine();

        try {
            scanFile = new Scanner(new File(salesFile));

            while (scanFile.hasNextLine()) {
                System.out.println(scanFile.nextLine());
            }
        } catch(FileNotFoundException fnfe) {
            System.out.println("Invalid file name supplied, please try again.");
        }
    }
}