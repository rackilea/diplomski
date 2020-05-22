public static List<Integer> readFile(String file) {
    List<Integer> chars = new ArrayList<>();
    try (FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);) {
        int ch;
        while ((ch = br.read()) != -1) {
            chars.add(ch);
        }
    } catch (FileNotFoundException e) {
        System.out.println("Missing file");
        System.exit(0);
    } catch (IOException e) {
        System.out.println("Empty file");
        System.exit(0);
    }
    return chars;
}