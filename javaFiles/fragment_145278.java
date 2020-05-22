final Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("test", Integer.valueOf(2));
    map.put("Not-Specified", Integer.valueOf(1));
    map.put("testtest", Integer.valueOf(3));

    final List<Entry<String, Integer>> entries =
        new ArrayList<Entry<String, Integer>>(map.entrySet());
    Collections.sort(entries, new Comparator<Entry<String, Integer>>(){

        public int compareKeys(final String o1, final String o2){
            int result;
            if("Not-Specified".equals(o1)){
                result = 1;
            } else if("Not-Specified".equals(o2)){
                result = -1;
            } else{
                result = o1.compareTo(o2);
            }
            return result;
        }

        @Override
        public int compare(final Entry<String, Integer> o1,
            final Entry<String, Integer> o2){
            return this.compareKeys(o1.getKey(), o2.getKey());
        }

    });

    final Entry<String, Integer> lastEntry =
        entries.get(entries.size() - 1);
    System.out.println("Last key: " + lastEntry.getKey() + ", last value: "
        + lastEntry.getValue());

}