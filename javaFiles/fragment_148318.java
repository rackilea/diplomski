ArrayList<String> resultList = new ArrayList<>();
ArrayList<String> linesList = new ArrayList<>();
// Input of file which needs to be parsed
String csvFile = "sample.csv";
BufferedReader csvReader;

// Data split by ',' in CSV file
String csvSplitBy = ",";
try {
    // Read the CSV file into an ArrayList array for easy processing.
    String line;
    csvReader = new BufferedReader(new FileReader(csvFile));
    while ((line = csvReader.readLine()) !=null) {
        linesList.add(line);
    }
    csvReader.close();
} 
catch (IOException e) { e.printStackTrace(); } 

// Process each CSV file line which is now contained within
// the linesList list Array
for (int i = 0; i < linesList.size(); i++) {
    String[] data = linesList.get(i).split(csvSplitBy);
    String col1 = data[0];
    String col2 = data[1];
    String col3YesNo = data[2];
    //int col4Value = Integer.parseInt(data[3]);  //WAS THIS
    double col4Value = Double.parseDouble(data[3]); // *** SHOULD BE ***
    String col5Unknown = data[4];

    // Determine if Column 1 and Column 2 data for the 
    // current line is unique to the entire CSV file.
    boolean columns1And2AreUnique = true;
    for (int j = 0; j < linesList.size(); j++) {
        String[] tmp = linesList.get(j).split(csvSplitBy);
        // Make sure we don't process the same line we are on...
        if (j != i) {
            if (col1.equals(tmp[0]) || col2.equals(tmp[1])) { 
                columns1And2AreUnique = false; 
                break;
            }
        }
    }
    if (columns1And2AreUnique && col3YesNo.equalsIgnoreCase("no") && col4Value >= 12.0) {
        resultList.add(linesList.get(i));
    }
}

// Display the determined results from the CSV file.
if (resultList.isEmpty()) {
    System.out.println("There could be no data results gathered from the supplied\n"
                     + "CSV file which meets the required criteria.");
}
else {
    System.out.println("Column 1\tColumn 2\tColumn 3\tColumn 4\tColumn 5");
    System.out.println("================================================"
                     + "========================\n");
    String padString = "        "; //Used for simple space padding in display
    for (int i = 0; i < resultList.size(); i++) {
        String[] tmp = resultList.get(i).split(csvSplitBy);
        System.out.println(tmp[0] + padString.substring(tmp[0].length()) + "\t" 
                         + tmp[1] + padString.substring(tmp[1].length()) + "\t" 
                         + tmp[2] + padString.substring(tmp[2].length()) + "\t"
                         + tmp[3] + padString.substring(tmp[3].length()) + "\t"
                         + tmp[4]);
    }
}