public static void main(String[] args) throws Exception {
    String[] strs = { "abc001", "efg.fqdn.com", "mnop-int", "help-adm.fqdn" };
    Pattern pattern = Pattern.compile("([^.-]*)[.-]?");
    for (String str : strs) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}