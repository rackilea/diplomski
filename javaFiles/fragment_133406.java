private static Map<String, Integer> getMovieMappings(String filePath)
        throws IOException {
    Map<String, Integer> movieMap = new HashMap<String, Integer>();
    BufferedReader br = null;
    try {
        br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(",");
            movieMap.put(temp[2].trim(), Integer.parseInt(temp[0].trim()));
        }
    } finally {
        if (br != null)   br.close(); 
    }
    return movieMap;
}