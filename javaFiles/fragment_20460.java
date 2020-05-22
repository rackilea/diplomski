public static void main(String[] args) throws FileNotFoundException {

    Scanner scanner = new Scanner(new File("foo.txt"));
    List<String> questions = new ArrayList<String>();
    List<String> other = new ArrayList<String>();
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (line.contains("?")) {
            questions.add(line);
        } else {
            other.add(line);
        }
    }
    System.out.println(questions);
    System.out.println(other);
}