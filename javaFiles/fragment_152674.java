package com.sel2in.sort;

    import java.util.ArrayList;
    import java.util.Comparator;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;
    import java.util.Map.Entry;
    import java.util.Set;

    public class TstMege {

        /**
         * @param args
         */
        public static void main(String[] args) {
            Map<String, String>mp = new HashMap<String, String>();

            //here instead of the test values load from your file and seperate key and value
            mp.put("tt", "nxcn3er3e33");
            mp.put("aa", "gjkrmt454");
            mp.put("zz", "rft56GDD");
            mp.put("zz", "rft56GDD");
            //sort
            Set<Entry<String, String>> entries = mp.entrySet();
            MapStrKeyComparator cpmr = new MapStrKeyComparator();
            MergeSort sorter = new MergeSort();
            //sort. sort(List<T> values, Comparator<T> comprtr)
            ArrayList<Entry<String, String>> lst = new ArrayList<Entry<String, String>>(entries.size());
            lst.addAll(entries);
            System.out.println("before " + lst);
            sorter.sort(lst, cpmr);
            System.out.println("sorted " + lst);

        }

    }