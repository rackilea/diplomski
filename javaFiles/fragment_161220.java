Arrays.sort(infoArray, new Comparator<String[]>() {
    public int compare(String[] o1, String[] o2) {
        return Double.compare(Double.parseDouble(o2[2]), 
                              Double.parseDouble(o1[2]));
    }
});