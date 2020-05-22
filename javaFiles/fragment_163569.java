public static <T> List<? extends List<T>> sortListByValue(List<? extends List<T>> list) {

    Collections.sort(list, new Comparator<List<T>>() {


        @Override
        public int compare(List<T> o1, List<T> o2) {
            //return Integer.compare(o1.size(), o2.size()); //JDK7 

            //Use this if you're using a version prior to 1.7.
            return Integer.valueOf(o1.size()).compareTo(o2.size());
        }
    });

    return list;
}   


public static void main(String[] args) {

    ArrayList<Map<String,String>> list1 = new ArrayList<>();
    list1.add(new HashMap<String, String>(){{ put("1", "a"); put("2", "b");}});
    list1.add(new HashMap<String, String>(){{ put("1", "a"); put("2", "b"); put("3", "c");}});
    list1.add(new HashMap<String, String>(){{ put("1", "a"); }});

    ArrayList<Map<String,String>> list2 = new ArrayList<>();
    list2.add(new HashMap<String, String>(){{ put("1", "a"); put("2", "b");}});
    list2.add(new HashMap<String, String>(){{ put("1", "a"); put("2", "b"); put("3", "c");}});

    ArrayList<Map<String,String>> list3 = new ArrayList<>();
    list3.add(new HashMap<String, String>(){{ put("1", "a"); put("2", "b");}});

    ArrayList<ArrayList<Map<String,String>>> list = new ArrayList<>();
    list.add(list1);
    list.add(list2);
    list.add(list3);
    System.out.println(list);
    System.out.println(sortListByValue(list));
}