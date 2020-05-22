public static void main(String[] args) {
    try {
        Scanner sc = new Scanner(new File("naval.txt"));
        String line;
        while (sc.hasNext()) {
            line = sc.nextLine();
            System.out.println(line);
        }   
    } catch (IOException e) {
        System.out.println(e.getMessage() + "\nNot possible to read the file");
    }
}