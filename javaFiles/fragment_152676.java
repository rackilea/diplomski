package com.sel2in.sort;

    import java.io.RandomAccessFile;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Map.Entry;

        public class TstFileMegeSort {

            /**
             * @param args
             */
            public static void main(String[] args) {
                //Map<String, String>mp = new HashMap<String, String>();
                ArrayList<Entry<String, String>> lst = new ArrayList<Entry<String, String>> (); 
                TEntry<String, String> en = null;
                //here instead of the test values load from your file and seperate key and value
                try {
                    RandomAccessFile data = new RandomAccessFile("data.bin","rws");
                    long l = data.length();
                    long recs = l / 1024;
                    long cnt = 0;
                    byte []b = new byte[1024];

                    while(cnt < recs){
                        cnt++;
                        data.readFully(b);
                        byte []key = Arrays.copyOfRange(b, 0, 24);
                        byte []value = Arrays.copyOfRange(b, 24, 1024);
                        en = new TEntry<String, String>(new String(key), new String(value));
                        lst.add(en);
                    }


                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                //sort
                //Set<Entry<String, String>> entries = mp.entrySet();
                MapStrKeyComparator cpmr = new MapStrKeyComparator();
                MergeSort sorter = new MergeSort();
                //sort. sort(List<T> values, Comparator<T> comprtr)
                //ArrayList<Entry<String, String>> lst = new ArrayList<Entry<String, String>>(entries.size());
                //lst.addAll(entries);
                System.out.println("before " + lst);
                sorter.sort(lst, cpmr);
                System.out.println("sorted " + lst);

            }

        }