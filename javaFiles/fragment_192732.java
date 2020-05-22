private static Pattern p1 = Pattern.compile("^TDXF.*\\w+-(\\d+)(\\.\\d+)+_(\\d+\\.)+\\d+");

private static Pattern p2 = Pattern.compile("^TD.{3}([0-9]).{4}$");

private static Pattern p3 = Pattern.compile("^.*_.*-.*-([0-9]*)\\..*\\..*\\..*$");

private static String getGroup(String gp) {
    String g = "";
    if (gp== null) {
        return g;
    }

    final Matcher matcher1 = p1.matcher(gp);
    final Matcher matcher2 = p2.matcher(gp);
    final Matcher matcher3 = p3.matcher(gp);

    if (matcher1.matches()) {
        g= matcher1.group(1) != null ? matcher1.group(1) : matcher1.group(2);
    }
    if (matcher2.matches()) {
        g= matcher2.group(1) != null ? matcher2.group(1) : matcher2.group(2);
    }
    if (matcher3.matches()) {
        g= matcher3.group(1) != null ? matcher3.group(1) : matcher3.group(2);
    }
    return g;
}