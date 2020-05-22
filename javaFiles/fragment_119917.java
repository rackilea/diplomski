File inFile = new File("C:\\Users\\User\\Selenium\\scrapjv\\interface\\NASDAQlist.txt");
    try {
        Scanner sc = new Scanner( inFile );
        List<String> symbolList = new ArrayList<String>();
        while (sc.hasNextLine()) {
            symbolList.add(sc.nextLine());
        }
    }
    catch ( FileNotFoundException e ) {
        System.out.println("Could not find file: " + inFile.getAbsolutePath());
    }