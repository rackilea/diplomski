try (Scanner sc = new Scanner(new File("patch"))) {
    Map<Integer, Integer> cols = new HashMap<>();
    while (sc.hasNextLine()) {
        String line = sc.nextLine();
        Scanner row = new Scanner(line);
        int colCount = 0;
        while (row.hasNextInt()) {
            int val = row.nextInt();
            if (cols.containsKey(colCount)) {
                val += cols.get(colCount);
            }
            cols.put(colCount, val);
            colCount++;
        }
    }
    for (int i : cols.values()) {
        System.out.printf("%d\t", i);
    }
    System.out.println();
} catch (IOException e) {
    e.printStackTrace();
}