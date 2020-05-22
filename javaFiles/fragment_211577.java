public class Application {

        public static void main(String... aArgs) throws IOException {

            InputParser firstListInputParser = new InputParser(new File(/**"Your path to /album.txt"*/));
            firstListInputParser.processLineByLine();
            List<String> firstList = firstListInputParser.getListWithParsedFolderNames();
            firstListInputParser.printMap();

            InputParser secondListInputParser = new InputParser(new File(/**"Your path to /new_album.txt"*/));
            secondListInputParser.processLineByLine();
            List<String> secondList = secondListInputParser.getListWithParsedFolderNames();
            secondListInputParser.printMap();

            // Create the list with common value and write it to the file
            List<String> listWithCommonValues = new ArrayList<String>(firstList);
            listWithCommonValues.retainAll(secondList);

            Path fileCommon = Paths.get(/**"Your path to /similar.txt"*/);
            Files.write(fileCommon, listWithCommonValues, Charset.forName("UTF-8"));

            // Create the list with different values and write it to the file
            List<String> listWithAllValues = new ArrayList<String>(firstList);
            listWithAllValues.addAll(secondList);
            //remove the common values from the list with all values
            listWithAllValues.removeAll(listWithCommonValues);

            Path fileDistincts = Paths.get(/**"Your path to /not_match.txt"*/);
            Files.write(fileDistincts, listWithAllValues, Charset.forName("UTF-8"));


        }

        private static void log(Object aObject){
            System.out.println(String.valueOf(aObject));
        }
    }