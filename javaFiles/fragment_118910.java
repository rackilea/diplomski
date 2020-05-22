// finds number of lines correctly
    int count = 0;
    List<String> lines = new ArrayList<String>();// use arrayList instead of arrays if you dont know the number of lines like we have here.
    while (readFile.hasNextLine()) {
        count++;
        lines.add(readFile.nextLine()); // notes the error here when not
                                        // initialized
    }
    System.out.println(count); // using the example table above it prints
                               // out 4

    relationTable = new boolean[count][count];
    int i = 0, j = 0, temp = 0;