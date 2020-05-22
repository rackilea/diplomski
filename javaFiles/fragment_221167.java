String[][] array = new String[][] { { "Barcelona", "156", "1604" }, 
        { "Girona", "256", "97" }, { "Tarragona", "91", "132" }, 
        { "Saragossa", "140", "666" } };
Arrays.sort(array, new Comparator<String[]>() {
    @Override
    public int compare(String[] o1, String[] o2) {
        return Integer.valueOf(o2[2]).compareTo(Integer.valueOf(o1[2]));
    }
});
System.out.println(Arrays.deepToString(array));