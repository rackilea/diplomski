// get i dashes as a string.
private static String getDashes(int i) {
    StringBuilder sb = new StringBuilder();
    while (i > 0) {
        sb.append("-");
        --i;
    }
    return sb.toString();
}

public static void main(String[] args) {
    Calendar calendar = Calendar.getInstance();
    calendar = new GregorianCalendar(2014, 07, 18);
    Date startDate = calendar.getTime();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy");
    String formatted = simpleDateFormat.format(startDate);

    // one format string
    String fmtString = "%-27s  %-10s  %5s  %s%n";
    // get the various dashes.
    String separator = String.format(fmtString, getDashes(26),
            getDashes(9), getDashes(5), getDashes(20));
    // format the header
    String header = String.format(fmtString, "Account", "Date", "Hours",
            "Skill");

    // format the body
    String output = String.format(fmtString, "Acme Industries", formatted,
            8, "software Engineer");

    // print
    System.out.println(header + separator + output);
}