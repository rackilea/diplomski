public static void main (String[] args) throws FileNotFoundException
{
    Scanner inputFile = new Scanner(new File("/home/tab.csv"));
    while(inputFile.hasNextLine()){
        String line = inputFile.nextLine();
        ArrayList<String> PPIData = new ArrayList<String>();
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter("\t");
        while(scanner.hasNext()){
            PPIData.add(scanner.next());
        }
        scanner.close();
        getResult(PPIData);
        System.out.println(PPIData);
    }