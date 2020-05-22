String prev = null;
String curr = null;
String next = null;

Scanner sc = new Scanner(new File("thefile.csv"));

while(sc.hasNextLine()) {
    prev = curr;
    curr = next;
    next = sc.nextLine();

    // now process those lines

}