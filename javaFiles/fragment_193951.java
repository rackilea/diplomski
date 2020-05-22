String csvFile = "C:/Users/piyush bhatia/Desktop/whois.csv";

    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
    String sFileName = "C:/Users/piyush bhatia/Desktop/whois2.csv";
    FileWriter writer = null;
    try {
        writer = new FileWriter(sFileName);
        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {

            // use comma as separator
            String[] country = line.split(cvsSplitBy);
            if (line.contains("AU")) {

                // writer.append(country[4]);
                writer.write(country[2]);

                System.out.println("Country [code= " + country[2]
                        + " , name=" + country[5] + "]");
            } else {

                System.out.println("");
            }

        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
                writer.flush(); // flush and close only once.
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    System.out.println("Done");
}