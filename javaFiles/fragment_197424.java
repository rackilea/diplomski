public static void main(String[] args) throws Exception {
    Pattern pat = Pattern.compile("(?<!function )\\w+");
    Matcher mat = pat.matcher("function example");
    while (mat.find()) {
        System.out.println(mat.group());
    }
}