public void testAlgorithm(){
        Map<String, List<String>> map = this.generateDatasource();
        Map<String, Integer> numberMap = this.calculateHappeds(map);
        Map<String, String> rstMap = new HashMap<String, String>();
        for (String key : map.keySet()) {
            List<String> sports = map.get(key);
            Integer index = 0;
            for (int i = 0; i < sports.size(); i++) {
                if (numberMap.get(sports.get(i)) > numberMap.get(sports.get(index))) {
                    index = i;
                }
            }
            rstMap.put(key, sports.get(index));
        }
        for (String key : rstMap.keySet()) {
            System.out.println(key + " = " + " [ " + rstMap.get(key) + " ]");
        }
    }

    private Map<String, Integer> calculateHappeds(Map<String, List<String>> map) {
        Map<String, Integer> calculate = new HashMap<String, Integer>();
        for (String key : map.keySet()) {
            List<String> sports = map.get(key);
            for (String sport : sports) {
                if (calculate.containsKey(sport)) {
                    Integer count = calculate.get(sport);
                    count += 1;
                    calculate.put(sport, count);
                }else {
                    calculate.put(sport,1);
                }
            }
        }
        return calculate;
    }

    private Map<String, List<String>> generateDatasource() {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> a = new ArrayList<String>();
        a.add("cricket");
        a.add("soccer");
        a.add("tennis");
        a.add("baseball");
        map.put("A", a);

        List<String> b = new ArrayList<String>();
        b.add("soccer");
        b.add("badminton");
        b.add("rugby");
        map.put("B", b);

        List<String> c = new ArrayList<String>();
        c.add("cricket");
        c.add("badminton");
        map.put("C", c);

        List<String> d = new ArrayList<String>();
        d.add("rugby");
        d.add("cricket");
        d.add("soccer");
        map.put("D", d);

        List<String> e = new ArrayList<String>();
        e.add("cricket");
        e.add("baseball");
        map.put("E", e);

        List<String> f = new ArrayList<String>();
        f.add("tennis");
        f.add("rugby");
        map.put("F", f);
        return map;
    }