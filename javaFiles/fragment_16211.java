public void populateData(String dataFile) {
    try {
        URL url = getClass().getResource(dataFile);
        File file = new File(url.toURI());
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                data.add(input.next());
            }
        }
    } catch (Exception ex) {
        System.out.println(ex.toString());
        ex.printStackTrace();
    }
}