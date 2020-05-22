public static void main(String[] args) throws java.lang.Exception {
    parseInformation("1y30d");
    parseInformation("1y2m30mi");
    parseInformation("1y1mi");
    parseInformation("1y2m3d4h5mi6s");
}

public static void parseInformation(String information) {
    Pattern p = Pattern.compile("(?:(\\d+)y)?(?:(\\d+)m(?!i))?(?:(\\d+)d)?(?:(\\d+)h)?(?:(\\d+)mi)?(?:(\\d+)s)?");
    Matcher m = p.matcher(information);
    while (m.find()) {
        if (m.group().isEmpty()) { continue; /* found nothing, go on */ }
        System.out.println(information + " found: '"+m.group()+"'");
        System.out.println("\t" + m.group(1) + " years");
        System.out.println("\t" + m.group(2) + " months");
        System.out.println("\t" + m.group(3) + " days");
        System.out.println("\t" + m.group(4) + " hours");
        System.out.println("\t" + m.group(5) + " minutes");
        System.out.println("\t" + m.group(6) + " seconds");
        System.out.println("");
    }