static final Comparator<String> myComparator = 
    new Comparator<String>() {
        public int compare(String s1, String s2)
        {
            // split s1 and s2, compare what you need
            // and return the result.
            // e.g.
            // char digit1 = s1[s1.length() - 1];
            // char digit2 = s2[s2.length() - 1];
            // return (int)(digit1 - digit2);
        }
     };

Collections.sort(list, myComparator);
// or
Arrays.sort(array, myComparator);