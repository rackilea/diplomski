public class Test1 {

    public static void main(String[] args) {

        String nameFile = "numbers.txt";
        String contentFile = readFromFileByName(nameFile);
        String altered = processText(contentFile);
        saveToFile(altered, "processed.txt");
    }


    private static String readFromFileByName(String nameFile) {
        String fullRead = "";
        try {
            File file = new File(nameFile);
            BufferedReader read = new BufferedReader(new FileReader(file));

            String line; // define line variable
            while((line = read.readLine()) != null) {
                    fullRead += line; // pay attention for the altered code
            }
            read.close();
        } catch (IOException e) {
            System.out.println("There was an error reading from a file");
        } finally {
            return fullRead;
        }
    }

    private static List<Integer> stringToIntList(String string) {
        return Arrays
            .stream(text.split(", "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private static String processText(String text) {
        String processed = text.replace('H', 'h'); // Some heavy processing :)
        return processed;
    }

    private static void saveToFile(String text, String fileName) {
        // save <text> to file with filename <filename>
    }

}