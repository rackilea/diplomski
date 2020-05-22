class Result {

    private static Pattern resultRegex = Pattern.compile(
        "(\\d+)" // 40
        + "\\s+"
        + "(\\d+\\.\\d+)" // 1655.28
        + "\\s+\\-+\\s+"
        + "(\\d+\\.\\d+)" // 212.61
        + "\\s+"
        + "(\\d+\\.\\d+)" // 2.01
        + "\\s+\\(\\s*" // (
        + "(\\d+\\.\\d+)" // 40.31
        + "%\\)\\s+\\(\\s*" // ) (
        + "(\\d)" // 9
        + "\\)" // )
        + "(.*)" // STRE C=C
        + "\\(" // (
        + "(.*)" // aminoA - part A
        + "\\)"); // )

    private final int col0;
    private final double col1;
    private final double col2;
    private final double col3;
    private final double col4;
    private final int col5;
    private final String col6;
    private final String col7;

    Result(String data) {

        Matcher matcher = resultRegex.matcher(data);
        matcher.find();
        col0 = Integer.parseInt(matcher.group(1));
        col1 = Double.parseDouble(matcher.group(2));
        col2 = Double.parseDouble(matcher.group(3));
        col3 = Double.parseDouble(matcher.group(4));
        col4 = Double.parseDouble(matcher.group(5));
        col5 = Integer.parseInt(matcher.group(6));
        col6 = matcher.group(7);
        col7 = matcher.group(8);
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append("col0=").append(col0)
            .append(",col1=").append(col1)
            .append(",col2=").append(col2)
            .append(",col3=").append(col3)
            .append(",col4=").append(col4)
            .append(",col5=").append(col5)
            .append(",col6=").append(col6)
            .append(",col7=").append(col7).toString();
    }
}