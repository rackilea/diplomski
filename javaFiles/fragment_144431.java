BufferedReader reader;

try {
    InputStream input = am.open("grades.txt");
    reader = new BufferedReader(new InputStreamReader(input));
    String line;

    while ((line = reader.readLine()) != null) {
        String[] parts = line.split("\\s+");
        finalList.addAll(Arrays.asList(parts));
    }

    input.close();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (reader != null) reader.close();
}