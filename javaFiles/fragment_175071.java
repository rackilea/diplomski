private void convertCsvtoMap(final String filePath) {
    try (Scanner in = new Scanner(new File(filePath))) {
        String line = null;
        Map<String, Double> resMap = new HashMap<>();
        while (in.hasNextLine()) {
            line = in.readLine();
            String[] fields = line.split(",");
            String key = fields[0].trim() + "|" + fields[1].trim() + ...;
            double value = Double.parseDouble(fields[5].trim());
            resMap.put(key, value);
        }
    } catch (Exception ex) {
        /* Handle Exception */
    }
}