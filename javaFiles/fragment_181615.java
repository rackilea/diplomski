Comparator<String> excelOrder = new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
       int s1Length = s1.length();
       int s2Length = s2.length();
       if (s1Length < s2Length) {
           return -1;
       } else if (s1Length > s2Length) {
           return 1;
       } else {
           return s1.compareTo(s2);
       }
    }           
};