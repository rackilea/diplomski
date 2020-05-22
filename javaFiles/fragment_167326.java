public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("STM-1000-H");
    list.add("STM-2000-E");
    list.add("SAFPX-1000-H-L2");
    list.add("SAFPX-1000-H-L1");
    list.add("STM-1000-H-L1");
    list.add("SFP-1000-B");
    list.add("SFP-1000-A");

    HashMap hm = new HashMap();
    hm.put("STM", 1);
    hm.put("SFP", 2);
    hm.put("SAFPX", 3);

    list = sort(list, hm);

    for (String s : list) {
        System.out.println(s);
    }
}

public static ArrayList<String> sort(ArrayList<String> list, HashMap<String, Integer> hashmap) {
    Comparator<String> comparator = (string1, string2) ->
    {
        String[] tokens1 = string1.split("-");
        String[] tokens2 = string2.split("-");

        if (hashmap.get(tokens1[0]) > hashmap.get(tokens2[0]))
            return 1;
        else if (hashmap.get(tokens1[0]) < hashmap.get(tokens2[0]))
            return -1;

        if (Integer.parseInt(tokens1[1]) > Integer.parseInt(tokens2[1]))
            return 1;
        else if (Integer.parseInt(tokens1[1]) < Integer.parseInt(tokens2[1]))
            return -1;

        if (tokens1.length > 2 && tokens2.length > 2) {
            int res = tokens1[2].compareTo(tokens2[2]);
            if(res != 0)
            return res;
        }

        if (tokens1.length > 3 && tokens2.length > 3) {
            int res = tokens1[3].compareTo(tokens2[3]);
            if(res != 0)
                return res;
        }

        return 0;
    };

    Collections.sort(list, comparator);
    return list;
}