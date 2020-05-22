public static void sortValue(Hashtable<?, Integer> t){

       //Transfer as List and sort it
       ArrayList<Map.Entry<?, Integer>> l = new ArrayList(t.entrySet());
       Collections.sort(l, new Comparator<Map.Entry<?, Integer>>(){

         public int compare(Map.Entry<?, Integer> o1, Map.Entry<?, Integer> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }});

       System.out.println(l);
    }