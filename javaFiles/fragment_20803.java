private static final Pattern DECIMAL = Pattern.compile("\\d*\\.?\\d+");
private static final Pattern FRACTION = Pattern.compile("\\.\\d+(\\s+\\d+/\\d+)");

public static void main(String args[]) {
    String[] samples = {"0000.2", "2", "2.222 1/2", "1 2/2", "0"};

    for (String sample : samples) {
        if (DECIMAL.matcher(sample).matches()) {
            float decimal = Float.parseFloat(sample);
            System.out.println(decimal + (decimal == 0 ? "\tERROR/Zero" : "\tDecimal"));
        }
        else {
            String fraction = FRACTION.matcher(sample).replaceFirst("$1");
            System.out.println(fraction + "\tFraction");
        }
    }
}