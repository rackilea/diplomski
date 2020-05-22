public static String format(String format, int num) {
    String[] split = format.split("\\|");
    int numLeft = num;
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < split.length; i++) {
        int boundary = Integer.parseInt(split[i]);
        int number = Math.min(numLeft, boundary);
        if (result.length() > 0) {
            result.append('|');
        }
        result.append(leftPad(number, split[i].length()));
        numLeft = Math.max(0, numLeft - boundary);
    }
    return result.toString();
}

private static String leftPad(int number, int length) {
    StringBuilder sb = new StringBuilder();
    sb.append(number);
    while (sb.length() < length) {
        sb.insert(0, '0');
    }
    return sb.toString();
}

public static void main(String[] args) {
    String result = format("25|35|40", 65);
    System.out.println(result);
}