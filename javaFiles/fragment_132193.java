public static void main(String[] args) throws SQLException {
    Pattern p = Pattern.compile("^(?:https?:\\/\\/)?(?:www\\.)?((?:[\\w]+\\.)+\\w+)");
    List<String> list = Arrays.asList("http://www.google.co.uk", "http://www.google.co.uk",
            "http://google.com.co.uk", "https://www.google.co.uk", "https://www.google.co.uk",
            "https://google.com.co.uk");

    list.forEach(x -> {
        Matcher m = p.matcher(x);
        if (m.matches()) {
            System.out.println(x + " --> " +m.group(1));
        }
    });
}