public static void main(String[] args) {
    Scanner s;
    try {
        s = new Scanner(new File("test.txt"));

        while(s.hasNextInt())
            System.out.println(s.nextInt());
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}