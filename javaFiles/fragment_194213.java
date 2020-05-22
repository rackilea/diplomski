ListMultimap<String, String> fileB = ArrayListMultimap.create();
try (FileReader frB = new FileReader(filenameB);
    BufferedReader brB = new BufferedReader(frB)) {
    String lineB;
    while ((lineB = brB.readLine()) != null) {
        String[] values = lineB.split(",");
        fileB.put(values[0], lineB); // map from first value to full line
    }
} catch (IOException e) {
    e.printStackTrace();
}

try (FileReader frA = new FileReader(filenameA);
    BufferedReader brA = new BufferedReader(frA)) {
    String lineA;
    while ((lineA = brA.readLine()) != null) {
        String value = lineA.split(",")[0];
        if (fileB.containsKey(value)) {
            System.out.println("Matches for " + value + ":");
            for (String line : fileB.get(value)) {
                System.out.println(line);
            }
        }
    }
} catch (IOException e) {
    e.printStackTrace();
}