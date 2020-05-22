try {
    PrintWriter writer = new PrintWriter("dboutput.txt");
    Scanner sc = new Scanner(new File("dbinput.txt"));
    sc.useDelimiter(Pattern.compile("^(?!.*(\\u0001\\n)).*\\n$"));
    while (sc.hasNext()) {
        writer.println(sc.next());
    }
    scanner.close();
    writer.close();
} catch (FileNotFoundException e) {
   e.printStackTrace();
}