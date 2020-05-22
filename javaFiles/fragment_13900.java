public static Comparator<String> dialPadNumCompare = new Comparator<String>(){
    @Override
    public int compare(String a, String b){
        int inta = stringToInt(a);
        int intb = stringToInt(b);
        if (inta == intb)
            return a.compareTo(b);
        return inta - intb;
    }
};