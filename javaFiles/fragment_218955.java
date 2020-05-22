try (Scanner sc = new Scanner(new File("patch"))) {
    List<List<Integer>> rows = new ArrayList<>();
    int colCount = 0;
    while (sc.hasNextLine()) {
        List<Integer> al = new ArrayList<>();
        String line = sc.nextLine();
        Scanner row = new Scanner(line);
        colCount = 0;
        while (row.hasNextInt()) {
            colCount++;
            int val = row.nextInt();
            al.add(val);
        }
        rows.add(al);
    }
    for (int i = 0; i < colCount; i++) {
        long sum = 0;
        for (List<Integer> row : rows) {
            sum += row.get(i);
        }
        if (i != 0) {
            System.out.print("\t");
        }
        System.out.print(sum);
    }
    System.out.println();
} catch (IOException e) {
    e.printStackTrace();
}