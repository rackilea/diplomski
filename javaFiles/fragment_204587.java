List<String> myList;
Collections.sort(myList, new Comparator<String>(){
    @Override
    public int compare(String o1, String o2) {
        String text1 = o1.split(":")[7];
        String text2 = o2.split(":")[7];
        return text1.compareTo(text2);
    }
});