public static void eventDetectionToken(String fileInput, String fileOuput)
        throws FileNotFoundException, IOException {
    FileWriter newCsv = new FileWriter(fileOuput + "." + "csv");
    BufferedWriter newCsvBW = new BufferedWriter(newCsv);
    BufferedReader reader = new BufferedReader(new FileReader(fileInput + ".csv"));
    String data;

    try {
        List<String> existanceTokens = new ArrayList<String>();

        do {
            data = reader.readLine();
            String tweetToken = null;

            if (data != null) {
                String[] splitText = data.split(",");
                tweetToken = splitText[5];

                if (!(existanceTokens.contains(tweetToken))) {
                    newCsvBW.append(data);
                    newCsvBW.append("\n");
                    existanceTokens.add(tweetToken);
                }
            }
        } while (data != null);
    } finally {
        newCsvBW.close();
        reader.close();
    }
}