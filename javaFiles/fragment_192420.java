public static void main(String[] args) {
    Scanner scan;
    File file = new File("resources\\scannertester\\data.txt");
    try {
        scan = new Scanner(file);

        while(scan.hasNextDouble())
        {
            System.out.println( scan.nextDouble() );
        }

    } catch (FileNotFoundException e1) {
            e1.printStackTrace();
    }

}