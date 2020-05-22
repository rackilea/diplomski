String csvFile = "path.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";

    try {

        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {

                // use comma as separator
            String[] parts = line.split(cvsSplitBy);
}

    } catch (Exception e) {
        e.printStackTrace();
    }