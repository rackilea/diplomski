public static void main(String[] args) {
    String s = "K ~\n" +
            "m W swim\n" +
            "sﬁaruqsr\n" +
            "wvnn 021m: r’ i\" W' _ ~\n" +
            "_ 4'“; x ‘ D\n" +
            "W ma ¢ “ii-a? “Rm qwﬂ\n" +
            "Electors name ; Moleslwar Moreshva;\n" +
            "Tuwal\n" +
            "mam-a #02,qu _\n" +
            "F\n" +
            "Fm“ Name : Momma! Tuppal I\n" +
            "‘ e\n" +
            "Pam sq» : w! MALE '\n" +
            "“WW/Dale m mm ; XX/xxnsae _‘";

    Pattern p = Pattern.compile("Electors name\\s*;\\s*([\\w; ]+\\n\\w+)");
    Matcher m = p.matcher(s);
    if (m.find()) {
        System.out.println(m.group(1).replaceAll(";\\n", " "));
    } else {
        System.out.println("Didn't match");
    }
}