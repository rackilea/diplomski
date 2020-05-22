public static int[] readFile() {
    BufferedReader br = null;
    String dataPoints;

    try {
        br = new BufferedReader(new FileReader("/tmp/file1"));
    } catch (IOException e) {
        System.out.println("Please enter data first");
        System.exit(0);
    }
    int[] integerHeightDataPoints = new int[0];
    try {
        while ((dataPoints = br.readLine()) != null) {
            if (dataPoints.contains(":")) {
                String[] heightDataPoints = dataPoints.split(":");
                integerHeightDataPoints = new int[heightDataPoints.length];
                for (int i = 0; i < integerHeightDataPoints.length; i++) {
                    integerHeightDataPoints[i] = Integer.parseInt(heightDataPoints[i]);
                }
                return integerHeightDataPoints;
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading file");
        e.printStackTrace();
    }
    return integerHeightDataPoints;
}