/**
 * This is a very basic parsing type method.<br><br>
 * 
 * Usage: {@code String[][] data = getFromCSV("Data.txt", "DataOutput.txt", 13, 16, 17, 28, 29); }
 * 
 * @param csvFilePath (String) The full path and file name of the Data file.<br>
 * 
 * @param destinationPath (String) The full path and file name of the desired output file. 
 * the retrieved data will be store there.<br>
 * 
 * @param desiredLiteralColumns (Optional - Integer Args or int[] Array) The literal
 * data columns to acquire row data from. The arguments can be provided in any desired
 * order. The returned Array will hold the required data in the order your provided.<br>
 * 
 * @return (2D String Array) Containing columnar data from each data row.
 */
public static String[][] getFromCSV(String csvFilePath, String destinationPath, 
                                    int... desiredLiteralColumns) {
    String ls = System.lineSeparator();   // The Line-Separator used for current OS.
    /* Does the destination Path exist? 
       If not create it before file is created. */
    File destPath = new File(destinationPath);
    if (!destinationPath.trim().equals("") && destPath.getParentFile() == null) {
        String fPath = destPath.getAbsolutePath().substring(0, destPath.getAbsolutePath().lastIndexOf("\\"));
        new File(fPath).mkdirs();
    }
    else {
        destPath.getParentFile().mkdirs();
    }

    ArrayList<String[]> list = new ArrayList<>();
    ArrayList<String> lineData = new ArrayList<>();
    File cisStaffHours = new File(csvFilePath);
    // 'Try With Resources' is used here to auto-close the reader.
    try (Scanner reader = new Scanner(cisStaffHours)) {
        String fileLine = "";
        // 'Try With Resources' is used here to auto-close the writer.
        try (PrintWriter writer = new PrintWriter(new FileWriter(destPath))) {
            while (reader.hasNextLine()) {
                /* Read lines one at a time. Trim each read in 
                  line of leading or trailing white-spaces (if any).  */
                fileLine = reader.nextLine().trim(); 
                // Skip blank lines (if any).
                if (fileLine.equals("")) {
                    continue;
                }
                /* Split the line based on a comma (,) delimiter)...
                   (DO NOT split on commas within quotation marks!).
                   The regular expression used with the split() method
                   ignores any number of white-spaces before or after
                   the delimiter.                    */
                String[] lineParts = fileLine.split("\\s{0,},\\s{0,}(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                //Do we only want specific columns only?
                if (desiredLiteralColumns.length > 0) {
                    // Yes...
                    lineData.clear(); // Clear the ArrayList in case it already contains something.
                    // Retrieve the desired columns an place them into a String ArrayList...
                    for (int dc : desiredLiteralColumns) {
                        for (int lp = 0; lp < lineParts.length; lp++) {
                            if (dc == (lp + 1)) {
                                lineData.add(lineParts[lp]);
                                break;
                            }
                        }
                    }
                    /* Convert the 'lineData' ArrayList to a 1D String Array
                       and then add that String Array to the 'list' ArrayList. */
                    list.add(lineData.toArray(new String[0]));

                    // Build and Write the acquired data to the desired output file.
                    String dataString = lineData.get(0).replace("\"", "") + ", " + 
                    lineData.get(1) + " " + lineData.get(2) + " , " + 
                    lineData.get(3).replace(".", " ") + lineData.get(4);
                    writer.println(dataString);
                    writer.flush();
                }
                else {
                    // No, we want all columns. Add all columnar data to the ArrayList...
                    list.add(lineParts);
                    // Build and Write the acquired data to the desired output file.
                    String dataString = lineData.get(0).replace("\"", "") + ", " + 
                    lineData.get(1) + " " + lineData.get(2) + " , " + 
                    lineData.get(3).replace(".", " ") + lineData.get(4);
                    writer.println(dataString);
                    writer.flush();
                }
            }
        }
        // Catch and display any exceptions,
        catch (IOException ex) {
            System.out.println("getFromCSV() Method Error!" + ls + ex.getMessage());
        }
    }
    catch (FileNotFoundException ex) {
        System.out.println("getFromCSV() Method Error!" + ls + ex.getMessage());
    }

    /* Convert list to a 2D String Array and then 
       return the 2D Array...         */
    String[][] array = new String[list.size()][];
    for (int i = 0; i < list.size(); i++) {
        array[i] = list.get(i);
    }
    return array;
}