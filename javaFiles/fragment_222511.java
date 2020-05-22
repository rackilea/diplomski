final Scanner input = new Scanner(System.in);
final Pattern pattern = Pattern.compile("\\d+\\.\\d{2}?");
while (input.hasNext()) {
  System.out.println((input.hasNext(pattern) ? "good" : "bad")
    + ": " + input.nextDouble());
}