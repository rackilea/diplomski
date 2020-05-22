public class Numbers {

private static final String[] s = new String[]{ "0",".",".0",".01","1.","1.0","1.01", "1 ","1 1","1/2","1/","1/0", "1 1/1", "1 0/0","1 /","1 /0", "1 0/"};

    private static final Pattern FRACTION_PATTERN = Pattern.compile("(?:(\\d+)\\s+)?(\\d+)/(\\d+)");

    public static void main(String[] args) {
        int counter = 0;
        for (String value : s) {
            counter++;
            String trimmedValue = value.trim();
            if (isNumber(trimmedValue)) {
                System.out.printf("%d) %s ---- Natural number%n", counter, trimmedValue);
                continue;
            }

            boolean parseDecimal = isProbablyDecimal(trimmedValue);
            boolean parseFraction = isProbablyFraction(trimmedValue);

            if (parseDecimal && parseFraction) {
                System.out.printf("%d) %s ---- Error (both decimal & fraction)%n", counter, trimmedValue);
                continue;
            }

            if (parseDecimal) {
                if (!trimmedValue.matches("\\d*[.]\\d+")) {
                    System.out.printf("%d) %s ---- Error (invalid decimal)%n", counter, trimmedValue);
                    continue;
                }
                System.out.printf("%d) %s ---- Decimal value%n", counter, trimmedValue);
                continue;
            }

            if (parseFraction) {
                Matcher m = FRACTION_PATTERN.matcher(trimmedValue);
                if (!m.matches()) {
                    System.out.printf("%d) %s ---- Error (invalid faction)%n", counter, trimmedValue);
                    continue;
                }
                if (Integer.valueOf(m.group(3)) == 0) {
                    System.out.printf("%d) %s ---- Error (division by zero in fraction)%n", counter, trimmedValue);
                    continue;
                }
                if (m.group(1) != null) {
                    System.out.printf("%d) %s ---- Mixed fraction%n", counter, trimmedValue);
                    continue;
                }

                System.out.printf("%d) %s ---- Fraction%n", counter, trimmedValue);
                continue;
            }

            System.out.printf("%d) %s ---- Error (Cannot make bread out of it)%n", counter, trimmedValue);
            continue;

        }
    }

    public static boolean isNumber(String value) {
        return value.matches("\\d+");
    }

    public static boolean isProbablyDecimal(String value) {
        // note, some countries use comma instead of dot
        return value.contains(".");
    }

    public static boolean isProbablyFraction(String value) {
        return value.contains("/");
    }
}