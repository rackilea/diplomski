private static int readSoleInteger(String path) {
    Scanner s = new Scanner(new File(path));
    int ret = s.nextInt();
    s.close();
    return ret;
}