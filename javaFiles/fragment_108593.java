public static void main(String[] args) throws Exception {

    TreeMap<Integer, HashSet<Integer>> originalMap = 
        new TreeMap<Integer, HashSet<Integer>>();

    originalMap.put(0, new HashSet<Integer>() {{ add(6); add(7); }});
    originalMap.put(1, new HashSet<Integer>() {{ add(6); }});
    originalMap.put(2, new HashSet<Integer>() {{ add(9); add(8); }});


    ArrayList<Map.Entry<Integer, HashSet<Integer>>> list = 
        new ArrayList<Map.Entry<Integer, HashSet<Integer>>>();
    list.addAll(originalMap.entrySet());

    Collections.sort(list, new Comparator<Map.Entry<Integer,HashSet<Integer>>>(){
        public int compare(Map.Entry<Integer, HashSet<Integer>> o1,
                           Map.Entry<Integer, HashSet<Integer>> o2) {

            Integer size1 = (Integer) o1.getValue().size();
            Integer size2 = (Integer) o2.getValue().size();
            return size2.compareTo(size1);
        }
    });

    System.out.println(list);
}