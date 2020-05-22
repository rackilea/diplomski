public static void main(String[] args) throws Exception {
    File myFile = new File("Sample.txt");

    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> labs = new ArrayList<String>();
    ArrayList<String> quizes = new ArrayList<String>();

    for (String line : Files.readLines(myFile, Charset.defaultCharset())) {
        String[] cols = line.split(" ");
        names.add(cols[0]);
        labs.add(cols[1]);
        quizes.add(cols[2]);
    }

    System.out.println(names);
    System.out.println(labs);
    System.out.println(quizes);
}