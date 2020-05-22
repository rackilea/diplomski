Map<String, List<String[]>> map = new TreeMap<String, List<String[]>>();
    for (String s : strings) {
        String[] tokens = s.split(" ");
        List<String[]> values = map.get(tokens[1]);
        if (values == null) {
            values = new ArrayList<String[]>();
            map.put(tokens[1], values);
        }
        values.add(new String[]{tokens[0],  tokens[3]});
    }

    for (String key : map.keySet()) {
        List<String[]> list = map.get(key);
        Collections.sort(list, new Comparator<String[]>() {

            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]) * -1;
            }

        });

        System.out.print(key + " ");
        for (String[] s : list) {
            System.out.print(s[0] + " " + s[1]);
        }
        System.out.println();
    }