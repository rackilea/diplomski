List<ArrayList<String>> csvLines = new ArrayList<ArrayList<String>>();
Comparator<ArrayList<String>> comp = new Comparator<ArrayList<String>>() {
    public int compare(ArrayList<String> csvLine1, ArrayList<String> csvLine2) {
        // TODO here convert to Integer depending on field.
        // example is for numeric field 2
        return Integer.valueOf(csvLine1.get(2)).compareTo(Integer.valueOf(csvLine2.get(2)));
    }
};
Collections.sort(csvLines, comp);