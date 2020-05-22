public static void main(String[] args) throws Exception {
    String test = "1212 and 120 or 390";
    Pattern p = Pattern.compile("^\\d+(\\s(and|or|not)\\s\\d+)*$");
    Matcher m = p.matcher(test);
    if (m.matches()) {
        System.out.println("Valid!");
    } else {
        System.out.println("Invalid.");
    }
}