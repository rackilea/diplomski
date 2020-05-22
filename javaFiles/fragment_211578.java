/**
         * Assumes UTF-8 encoding
         */
        public class InputParser {

            //create a list to hold the values
            List<String> listWithParsedFolderNames = new ArrayList<>();


            //private final Path fFilePath;
            private final File file;
            private final static Charset ENCODING = StandardCharsets.UTF_8;

            /**
             Constructor.
             @param aFileName full name of an existing, readable file.
             */
            public InputParser(File aFileName){
                //fFilePath = Paths.get(aFileName);
               file = aFileName;
            }

            /**
             * Processes each line and calls {@link #processLine(String)}}.
             */
            public final void processLineByLine() throws IOException {
                try (Scanner fileScanner = new Scanner(file, ENCODING.name())){
                    while (fileScanner.hasNextLine()){
                        processLine(fileScanner.nextLine());
                    }
                }
            }

            /**
             Overridable method for processing lines in different ways.
             *Parses the line and cuts away the part after '(update'
             * Ex1: input line: @Event1(update20-05-2015)
             * Ex1: output    : @Event1
             *
             * Ex2: input line: @Event2
             * Ex2: output    : @Event2
             */
            protected void processLine(String aLine){

                    Scanner scanner = new Scanner(aLine);

                    if (scanner.hasNext()) {
                        String name = scanner.next();
                        String finalName = name.split("\\(update")[0];

                        //stores the values in the list
                        listWithParsedFolderNames.add(finalName);

                    } else {
                        log("Empty or invalid line. Unable to process.");
                    }

            }

            /**
             * Prints the content of the listWlistWithParsedFolderNames
             */
            public void printMap() {
                Iterator it = listWithParsedFolderNames.iterator();
                while (it.hasNext()) {
                    log("The prsed value is: " + it.next());
                }
            }

            /**
             * @return the list with values
             */
            public List<String > getListWithParsedFolderNames() {
                return this.listWithParsedFolderNames;
            }


            private static void log(Object aObject){
                System.out.println(String.valueOf(aObject));
            }

        }