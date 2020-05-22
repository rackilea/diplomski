public static List<String> simplify(BufferedReader input) throws IOException {
    String line = null;
    List<String> result = new ArrayList<String>();

    while ((line = input.readLine()) != null) {
        result.add(line.replaceAll ("[^a-zA-Z0-9 ]", "").toLowerCase());
    }    
    return result;
}