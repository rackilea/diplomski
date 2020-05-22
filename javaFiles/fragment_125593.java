public static void main(String[] args) throws ParseException {
    String input = "45,78";
    NumberFormat from = DecimalFormat.getNumberInstance(Locale.FRANCE);
    NumberFormat to = DecimalFormat.getNumberInstance(Locale.US);
    String output = to.format(from.parse(input));
    System.out.println(output); // "45.78"
}