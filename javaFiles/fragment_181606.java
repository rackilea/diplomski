public static int getSum(String line) {
    final Pattern p = Pattern.compile("-?\\d+"); //regex to extract numbers from string
    final Matcher m = p.matcher(line);
    int sum = 0;
    while (m.find()) {
        sum += Integer.parseInt(m.group());
    }
    return sum;
}

public static void main(String[] args) throws FileNotFoundException {
    final Scanner scanner = new Scanner(new File("xxx.txt"));

    System.out.println("--------");
    while (scanner.hasNextLine()) {
        final String line = scanner.nextLine();
        System.out.println(line);
        System.out.println("Sum is: " + getSum(line)); //for each line get the sum
        System.out.println("--------");
    }
    scanner.close();
}