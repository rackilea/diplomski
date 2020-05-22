Scanner scanner = new Scanner(inFile);     
    String[] size = scanner.nextLine().split("\\s");         

    char[][] array = new char[Integer.parseInt(size[0])][Integer.parseInt(size[1])];

    for(int i=0; i < rows; i++) {
        array[i] = scanner.nextLine().toCharArray();
    }