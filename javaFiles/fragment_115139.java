public static void main(String[] args) {


    for (String part : getParts("limited screen space to display information", 7, 3)) {
        System.out.println(part);
    }
}

private static List<String> getParts(String string, int partitionSize, int maxLine) {
    List<String> parts = new ArrayList<String>();
    int len = string.length();
    for (int i = 0; i < len; i += partitionSize) {
        parts.add(string.substring(i, Math.min(len, i + partitionSize)));
        maxLine++;
        if (maxLine == 3) {
            break;
        }

    }
    return parts;
}