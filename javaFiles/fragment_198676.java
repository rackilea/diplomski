try {
    keyboardIn = new Scanner(new FileInputStream("file.txt"));
} catch (FileNotFoundException e) {
    System.out.println("file \"file.txt\" not found");
    e.printStackTrace();
}