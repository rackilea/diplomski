public static void main(String[] args) {
    String phrase = "From the torrent, or the fountain, From the red cliff of the mountain";
    //or whatever method of getting the individual words you want.
    //I just chose StringTokenizer (obviously)
    StringTokenizer st = new StringTokenizer(phrase, " ,");
    TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {

        @Override
        public int compare(String s1, String s2) {
            int retVal = Integer.compare(s1.length(), s2.length());
            if(retVal == 0){
                retVal = s1.compareTo(s2);
            }
            return retVal;
        }
    });
    while(st.hasMoreTokens()){
        ts.add(st.nextToken());
    }
    for(String s : ts.descendingSet()){
        System.out.println(s + " " + s.length());
    }
}