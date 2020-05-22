public static void main(String[] args) {

    Map<String, String> sColorNameMap = new HashMap<>();

    String rgbCode = "B23634";

    String colorName;
    if (sColorNameMap.containsKey(rgbCode)) {
        colorName = sColorNameMap.get(rgbCode);
    } else {
        colorName = nearestColor(rgbCode, sColorNameMap);
    }

    System.out.println("colorName = " + colorName);

}

private static String nearestColor(String code, Map<String, String> sColorNameMap) {

    int[] rgb = getRgb(code);

    double nearestDistance = Double.MAX_VALUE;
    String nearestNamedColorCode = null;

    for (String namedColorCode : sColorNameMap.keySet()) {
        int[] namedColorRgb = getRgb(namedColorCode);
        double distance = calculateDistance(rgb, namedColorRgb);
        if (distance < nearestDistance) {
            nearestDistance = distance;
            nearestNamedColorCode = namedColorCode;
        }
    }

    return sColorNameMap.get(nearestNamedColorCode);

}

private static int[] getRgb(String code) {

    int r = Integer.parseInt(code.substring(0, 2), 16);
    int g = Integer.parseInt(code.substring(2, 4), 16);
    int b = Integer.parseInt(code.substring(4, 6), 16);

    return new int[]{r, g, b};

}

private static double calculateDistance(int[] rgb1, int[] rgb2) {

    double sum = 0.0;
    for (int i = 0; i < 3; i++) {
        sum += Math.pow(rgb2[i] - rgb1[i], 2);
    }
    return Math.sqrt(sum);

}