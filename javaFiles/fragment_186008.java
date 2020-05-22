public static void main(final String[] args) {
    final ArrayList<String> uniqueFileTypes = new ArrayList<String>();
    uniqueFileTypes.add(".java");
    uniqueFileTypes.add(".zip");
    uniqueFileTypes.add(".docx");

    final ArrayList<Integer> countFileTypes = new ArrayList<Integer>();
    countFileTypes.add(5);
    countFileTypes.add(8);
    countFileTypes.add(2);

    final Map<Integer, String> countedFileTypes = new HashMap<Integer, String>();

    for (int i = 0; i< uniqueFileTypes.size(); i++ ) {
        countedFileTypes.put(countFileTypes.get(i), uniqueFileTypes.get(i) );
    }

    Collections.sort(countFileTypes);
    Collections.reverse(countFileTypes);

    final Object[][] data = new Object[countedFileTypes.size()][3];

    for(int i = 0; i<countedFileTypes.size(); i++) {
        final Integer count = countFileTypes.get(i);
        data[i] = new Object[]{(i+1), countedFileTypes.get(count), count};
        System.out.println("{" + (i+1) + "," + countedFileTypes.get(count) + "," + count + "}");
    }
}