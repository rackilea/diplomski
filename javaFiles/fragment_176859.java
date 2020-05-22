Collections.sort(myArray,new Comparator<String>(){
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public int compare(String s1, String s2){
        return sdf.parse(s1).compareTo(sdf.parse(s2));
    }

});