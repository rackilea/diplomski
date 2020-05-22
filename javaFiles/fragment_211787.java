public static void main(String[] args) {
    Matcher m = Pattern.compile("^(0039|\\+39)").matcher("00392121");

    if (m.find())
        System.out.println("Found");
}