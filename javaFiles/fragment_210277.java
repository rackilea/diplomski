Scanner sc = new Scanner(new File(inFile));
    arraySize = sc.nextInt();
    elements = new String[arraySize];

    while(sc.hasNext())
    {
        sc.nextInt();
        elements[index] = sc.next();
        index += 1;
    }