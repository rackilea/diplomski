public class Main {

public static void main(String[] args) throws Exception {
    //1. create Scanners that will look through the CSV files
    Scanner main = new Scanner(new File("main.csv"));
    Scanner look = new Scanner(new File("look.csv"));

    //2. create the final CSV file that will contain both the replaced words and non-replaced words from main.csv
    FileWriter replaced = new FileWriter(createReplacedCsv());

    //3. store contents of look.csv in a Map
    Map<String, String> lookCsvWords = storeLookCsvInSet(look);

    //4. Store the contents of the file in a StringBuilder, so you can use the StringBuilder.deleteCharAt(int)
    // and .lastIndexOf(String) to delete the last comma
    StringBuilder builder = new StringBuilder();

    //5. keep track of the line we are on
    int line = 0;

    //6. iterate through main.csv and search for replaceable words, and write them to replaced.csv if they are found
    while (main.hasNext()) {

        //search the first line for replaceable chars
        String[] wordsInLine = main.nextLine().split(",");
        for (String word : wordsInLine) {
            if (lookCsvWords.containsKey(word) && line == 0) {
                word = lookCsvWords.get(word);
            }
            builder.append(word).append(",");
        }
        line ++;
        builder.deleteCharAt(builder.lastIndexOf(","));
        builder.append("\n");
    }

    //7. write the contents of the StringBuilder to the file
    replaced.write(builder.toString());
    replaced.close();
}

/*
 * Creates the replaced.csv file if it doesn't exist
 */
private static File createReplacedCsv() throws Exception {
    File replacedCsv = new File("replaced.csv");
    replacedCsv.createNewFile();
    return replacedCsv;
}

/*
 * Store the words within look.csv in a Map.
 * This method assumes that look.csv has only two lines
 */
private static Map<String, String> storeLookCsvInSet(Scanner lookScanner) throws Exception {
    Map<String, String> lookCsvWordMappings = new HashMap<String, String>();
    String[] line1Values = lookScanner.nextLine().split(",");
    String[] line2Values = lookScanner.nextLine().split(",");

    for (int i=0; i<line1Values.length; i++) {
        lookCsvWordMappings.put(line1Values[i], line2Values[i]);
    }
    return lookCsvWordMappings;
}