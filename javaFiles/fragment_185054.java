private static Integer STUDENT_ID_COLUMN = 0;
private static Integer STUDENT_KEY_COLUMN = 1;
private static Integer YEAR_LEVEL_COLUMN = 2;
private static Integer STUDENT_NAME_COLUMN = 3;
private static Integer TOKEN_COLUMN = 4;

public static void main(String[] args) {

    ArrayList<String> studentTokens = new ArrayList<>();

    try (FileInputStream fstream = new FileInputStream("test.txt");
          InputStreamReader inputStreamReader = new InputStreamReader(fstream);
          BufferedReader br = new BufferedReader(inputStreamReader)) {

        String strLine;

        // Read File Line By Line
        while ((strLine = br.readLine()) != null) {

            strLine = strLine.trim();

            if ((strLine.length() != 0) && (strLine.charAt(0) != '#')) {
                String[] columns = strLine.split("\\s+");
                studentTokens.add(columns[TOKEN_COLUMN]);
            }

        }
    }
    catch (Exception e) {// Catch exception if any
        System.err.println("Error: " + e.getMessage());
        return;
    }

    for (String s : studentTokens) {
        System.out.println(s);
    }
}