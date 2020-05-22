public static void main(String[] args) throws Exception {
    String regulex = "#?([^#]+)#?"; //even this guy returns no matches

    System.out.println(checkRegex("#sel=45#", regulex));
    System.out.println(checkRegex("sel=45", regulex));
}

public static String checkRegex(String check, String regex) {
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(check);
    return m.matches() ? m.group(1): null;
}