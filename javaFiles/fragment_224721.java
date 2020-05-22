Scanner fileReader = new Scanner(new FileReader("pets.txt"));
    fileReader.useLocale(Locale.US);

    double age = 0, weight = 0;
    int counter = 0;

    // A while loop to read until there are no more lines
    while(fileReader.hasNext()) {
        fileReader.useDelimiter(",");
        System.out.println(fileReader.next());
        System.out.println(fileReader.nextInt());
        fileReader.useDelimiter(Pattern.compile("[\\r\\n,]+"));
        System.out.println(fileReader.nextDouble());

    }

    fileReader.close();