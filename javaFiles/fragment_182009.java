File file = new File("test.txt");
    String word = "abc,catch,profile";
    Scanner scanner = null;

    try {
        scanner = new Scanner(file);
    } catch (FileNotFoundException e) {
        System.out.println("Error  " + e);
    }

    // now read the file line by line
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(word, ",");
        while (st.hasMoreTokens()) {
            if (line.contains(st.nextToken())) {
                System.out.println(line);
                break;
            }
        }
    }
    scanner.close();`