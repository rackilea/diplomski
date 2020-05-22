HashMap<String, String> set1 = new HashMap<>();
    HashMap<String, String> set2 = new HashMap<>();
    class Pair{
        String str1;
        String str2;

        Pair(String s1, String s2){
            str1 = s1;
            str2 = s2;
        }
    }
    Set <Pair> pairs = new HashSet<>();
    set1.put("tag", "tag");
    set1.put("bold", "boLD");
    set1.put("link", "Link");
    set2.put("tag", "TAG");
    set2.put("bold", "BOLd");
    set2.put("badge", "Badge");
    set2.put("foo", "foo");

    for (String s : set1.keySet()){
        if (set2.containsKey(s))
            pairs.add(new Pair(set1.get(s), set2.get(s)));
        else
            pairs.add(new Pair(set1.get(s), null));
    }

    for (String s : set2.keySet()){
        if (!set1.containsKey(s))
            pairs.add(new Pair(null, set2.get(s)));
    }

    for(Pair p : pairs)
        System.out.println(p.str1 + " " + p.str2);