public static Map<String, String> getRels(String relsFile) {
    Map<String, String> map = new LinkedHashMap<String, String>();
    BufferedReader br = null;
    try {
        br = new BufferedReader(new FileReader(relsFile));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",", 2);
            if (parts.length > 1)
                map.put(parts[0], parts[1]);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (br != null) br.close();
        } catch (IOException ignored) {
        }
    }
    return map;
}