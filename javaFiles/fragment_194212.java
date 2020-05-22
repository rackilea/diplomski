try (FileReader frA = new FileReader(filenameA);
    BufferedReader brA = new BufferedReader(frA)) {
    String lineA;
    while ((lineA = brA.readLine()) != null) {
        String value = lineA.split(",")[0];
        try (FileReader frB = new FileReader(filenameB);
            BufferedReader brB = new BufferedReader(frB)) {
            boolean found = false;
            String lineB;
            while ((lineB = brB.readLine()) != null) {
                String[] values = lineB.split(",");
                if (value.equals(values[0])) {
                    if (!found) {
                        System.out.println("Matches for " + value + ":");
                    }
                    System.out.println(lineB);
                    found = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} catch (IOException e) {
    e.printStackTrace();
}