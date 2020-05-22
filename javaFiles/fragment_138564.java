public static List<List<Integer>> readFile(final String path) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Path p = Paths.get(path);
    if (!Files.exists(p))
        return null;
    List<String> lines = null;
    try {
        lines = Files.readAllLines(p);
    } catch (IOException e) {
        e.printStackTrace();
    }
    if (lines == null)
        return null;
    for (String str : lines) {
        List<Integer> row = new ArrayList<Integer>();
        final String line = str.substring(1, str.length() - 1);
        String[] arr = line.split(" ");
        for (String s : arr)
            row.add(Integer.valueOf(s.trim()));
        result.add(row);
    }
    return result;
}