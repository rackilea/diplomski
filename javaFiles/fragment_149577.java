public static void main(String[] args) {
    String s = "Bolighus fullverdi 4 374 720 12 000 11 806";
    s = s.replaceAll(" (?=\\d{3})", "");
    System.out.println("Transformed string: " + s);
    Pattern p = Pattern.compile(".*\\d+\\s+(\\d+)\\s+\\d+");
    Matcher m = p.matcher(s);
    if (m.find()) {
        System.out.println(m.group(1));
    } else {
        System.out.println("Didn't match");
    }
}