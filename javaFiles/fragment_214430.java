for(Map.Entry<HashSet<String>, Long> e: hm.entrySet()) {
        List<String> li = simplify(e.getKey());
        Collections.sort(li, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(), o1.length());
            }
        });
        System.out.println(li.toString());
    }