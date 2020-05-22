class MyComp implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        return -1 * str1.compareTo(str2);
    } 
}