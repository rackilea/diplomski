try {
    Scanner s = new Scanner(new File("my/path/foo.txt"));
    s.useDelimiter(",\\s?");
    while (s.hasNext()) {
        System.out.println(s.next());
    }
}
catch (FileNotFoundException fnfe) {
    fnfe.printStackTrace();
}