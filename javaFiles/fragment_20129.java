public static void main(String[] args) {
    String str = "Hello69World 2, Nic8e D7ay!";
    Pattern p = Pattern.compile("(?<!\\d)\\d(?!\\d)");
    Matcher m = p.matcher(str);
    while (m.find()) {
        System.out.println(m.group());
    }

    System.out.println("***********");

    str = "Hello6 9World 2, Nic8e D7ay!";
    m = p.matcher(str);
    while (m.find()) {
        System.out.println(m.group());
    }

}