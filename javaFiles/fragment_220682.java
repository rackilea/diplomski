public class JavaJustifier {
    static int counter = 0;
    static int tabSize = 4;

    public static void main(String[] args) throws FileNotFoundException {
        justifyJava("Test1.java", "Justified1.txt");
    }

    private static void processLine(PrintStream name, String line) {
        if (line.contains("{")) {
            String preText = line.substring(0, line.indexOf("{"));
            String postText = line.substring(line.indexOf("{") + 1)
                    .replaceAll("\\n", "").replaceAll("\\r\\n", "");
            printSpaces(name);
            name.println(preText);
            printSpaces(name);
            name.println("{");
            counter++;
            processLine(name, postText);

        } else if (line.contains("}")) {
            String preText = line.substring(0, line.indexOf("}"));
            String postText = line.substring(line.indexOf("}") + 1)
                    .replaceAll("\\n", "").replaceAll("\\r\\n", "");
            name.println(preText);
            counter--;
            printSpaces(name);
            name.println("}");
            processLine(name, postText);
        } else {
            if (!line.equals("\r\n") && line.length() != 0) {
                printSpaces(name);
                name.print(line);
            }
        }
    }

    private static void printSpaces(PrintStream p) {
        for (int i = 1; i <= counter; i++) {
            for (int j = 0; j <= tabSize; j++) {
                p.print(" ");
            }
        }
    }

    public static void justifyJava(String inputFileName, String outputFileName)
            throws FileNotFoundException {

        File f = new File(inputFileName);
        File p = new File(outputFileName);
        if (p.exists())
            p.delete();
        Scanner input = new Scanner(f);
        PrintStream name = new PrintStream(new File(outputFileName));

        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            processLine(name, line);
        }
    }
}