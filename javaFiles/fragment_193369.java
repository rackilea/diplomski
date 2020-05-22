File file = new File ("input.txt");
Scanner scanner = null;
try {
    scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
        myFunc (scanner.nextLine());
    }
} catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} finally {
    if (scanner!=null)
        scanner.close();
}