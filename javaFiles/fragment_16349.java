import java.util.Comparator;
    class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            if(a.contains("-") && !b.contains("-"))
                 return 1;
            else if(!a.contains("-") && b.contains("-"))
                 return -1;
            return a.compareTo(b);
        }
    }
    Collections.sort(arrays, new CustomComparator());