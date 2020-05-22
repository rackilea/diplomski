public void studentAverage() throws FileNotFoundException {
    File infile= new File("qdata.txt");
    Scanner sc = new Scanner(infile);
    double rowNum = 0;
    List<List<Integer>> grades = new ArrayList<>();
    double totalCount = 0.0;
    while (sc.hasNext()) {
        List<Integer> row = new ArrayList<>();
        Scanner lineScanner= new Scanner(sc.nextLine());
        while (lineScanner.hasNextInt()) {
            row.add(lineScanner.nextInt());
        }
        grades.add(row);
        totalCount += row.size();
    }

    int index = 0;
    for (List<Integer> list : grades) {
        for (Integer grade : list) {
          System.out.println("Student average is " + (double)Math.round(grade.doubleValue() / totalCount * 10) / 10);
        }
    }
}