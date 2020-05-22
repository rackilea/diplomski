package com.sel2in.sort;

    import java.util.Comparator;    
    import java.util.Map.Entry;

    /** compare 2 strings, taken from the key of a Map entry - Tushar Kapila */
    public class MapStrKeyComparator implements Comparator<java.util.Map.Entry<String,Object>> {
        @Override
        public int compare(Entry<String,Object> o1, Entry<String,Object> o2) {
            String s = o1.getKey().toString();
            String n = o2.getKey().toString();
            return s.compareTo(n);

        }
    }