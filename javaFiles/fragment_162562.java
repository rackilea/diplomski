String input() {
    InputStream is = new FileInputStream(INPUT_FILE_NAME);
    Scanner s = new Scanner(is);
    String str = s.nextLine();
    s.close();
    return str;
}