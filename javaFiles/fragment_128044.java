public static void main(String [] args) throws FileNotFoundException{
    Set<String> damagedFiles = new LinkedHashSet<String>();
    File file = new File("C:\\log.txt");
    Scanner scanner = new Scanner(file);
    String filename = null;


    try {
        int lineNum = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.startsWith("Input #0")){
                /*if desired, can use a regex lookahead to get only the path and filename
                    instead of the entire Input #0 line */
                filename = line;
            }
            if(line.contains("damaged")){
                if (filename != null){
                    damagedFiles.add(filename);
                }
            }
        }
    } finally {
        scanner.close();
        for (String s : damagedFiles){
            System.out.println(s);
        }
    }
}