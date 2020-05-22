public static void main(String[] args) {

    // write
    String delimiter = "#";
    StringWriter stringWriter = new StringWriter();
    PrintWriter pw = new PrintWriter(stringWriter);
    pw.println(3);
    for (int i = 0; i < 3; i++) {
        pw.print("id " + i);
        pw.print(delimiter);
        pw.print("titel " + i);
        pw.print(delimiter);
        pw.print("artist " + i);
        pw.println(delimiter);
    }

    String theString = stringWriter.toString();
    System.out.println(theString);

    try {
        pw.close();
        stringWriter.close();
    } catch (IOException e) {
        // ignore in example
    }

    // read
    Scanner in = new Scanner(theString);
    in.useDelimiter("\\s*#\\s*|\\s*\n\\s*"); // add new line as delimiter aswell
    int libSize = in.nextInt();
    for (int i = 0; i < libSize; i++) {
        String inId = in.next();
        String inTitle = in.next();
        String inArtist = in.next();
        in.nextLine();

        System.out.println("read: " + inId + ", " + inTitle + ", " + inArtist);
    }
    in.close();
}