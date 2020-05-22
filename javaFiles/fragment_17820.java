BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));

try {
    System.out.print("Enter no of semester : ");

    int noSem = Integer.parseInt(inData.readLine());
    String[][] sbjName = new String[noSem][];

    // Semester loop
    for (int i = 0; i < noSem; i++) {
        System.out.println("\n\tSemester" + (i + 1));
        System.out.print("Enter number of course : ");

        int noCourse = Integer.parseInt(inData.readLine());
        sbjName[i] = new String[noCourse];

        // course details loop
        for (int u = 0; u < noCourse; u++) {
            System.out.println("Enter Course Code : ");
            System.out.print("Enter Course Name : ");
            sbjName[i][u] = inData.readLine();

            System.out.println("Enter Credit Hour : ");
            System.out.println("Enter Marks : ");
            System.out.println("\n");
        }
    }

    for (int x = 0; x < sbjName.length; x++) {
        for (int y = 0; y < sbjName[x].length; y++) {
            System.out.println(sbjName[x][y]);
        }
    }
}