public static void addShapes(){
    BounceBox box = new BounceBox(700,500);
    try {
        FileInputStream fileIn = null;
        fileIn = new FileInputStream("ex3.txt");
        Scanner scan = new Scanner(fileIn);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    box.start();
}