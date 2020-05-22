Collections.sort(outerArr, new Comparator<String[]>() {
    public int compare(String[] o1, String[] o2)
    {
        // for example you can compare integers
        return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
    }
});