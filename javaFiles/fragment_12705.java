Scanner fileScanner = new Scanner(new File(fileInput));
    while (fileScanner.hasNext()) {
        System.out.println(fileScanner.next());
    }
    scanner.close();
    fileScanner.close();