public static ArrayList<BigDecimal> getNumbers(String s) {
    ArrayList<BigDecimal> numbers = new ArrayList<>();

    // regular expression
    Pattern p = Pattern.compile("current num\\s?=\\s?(\\d+\\.?\\d*)");
    Matcher m = p.matcher(s);
    // find matches
    while (m.find()) {
        // print out the number after current num =
        numbers.add(new BigDecimal(m.group(1)));
    }
    return numbers;
}

public static void main(String[] args) {
    String s = "current num = 120 current num = 50.5";

    ArrayList<BigDecimal> numbers = getNumbers(s);
    for (BigDecimal number: numbers) {
        System.out.println(number.toString());
    }
}