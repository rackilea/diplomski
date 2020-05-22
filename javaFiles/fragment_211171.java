public static void main(String[] args) {
    String testdata = "55°\r\n" +
                      "bad line with no number\r\n" +
                      "Two numbers: 123   $78\r\n";
    ArrayList<Integer> arrayInt = new ArrayList<>();
    try (Scanner readFile = new Scanner(testdata)) {
        Pattern digitsPattern = Pattern.compile("(\\d+)");
        while (readFile.hasNextLine()) {
            Matcher m = digitsPattern.matcher(readFile.nextLine());
            while (m.find())
                arrayInt.add(Integer.valueOf(m.group(1)));
        }
    }
    System.out.println(arrayInt);
}