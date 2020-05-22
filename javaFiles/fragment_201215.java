public static void main(String[] args) {

    // initialize arraylists
    ArrayList<String> Names      = new ArrayList<String>();
    Map<String,Integer> map      = new HashMap<>();

    // sample data              // I want the integer Arraylist to have values:
    Names.add("Hans");          // 1
    Names.add("Max");           // 2
    Names.add("Hans");          // 1
    Names.add("Hans");          // 1
    Names.add("Frank");         // 3

    int N = Names.size();

    int id = 0;
    for (int i = 0; i < N; i++) {
        String name = Names.get(i);
        if (map.get(name) == null) {
            map.put(name,++id);
        }
    }

    // show result
    for (int i=0; i<N; i++) {
        String name = Names.get(i);
        System.out.println(map.get(name) + " " +name);
    }

}