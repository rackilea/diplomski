public static void addShapes() throws FileNotFoundException {
        BounceBox box = new BounceBox(700,500);

        FileInputStream fileIn = new FileInputStream("ex3.txt");
        Scanner scan = new Scanner(fileIn);

        box.start();
    }