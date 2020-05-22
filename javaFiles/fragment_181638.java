// If you have setup like this
Map<Integer, Map<String, String>> m = new HashMap<>();
Map<String, String> c1 = new HashMap<>();
c1.put("Context", "Legacy");
c1.put("Owner", "Ram");
c1.put("Number", "xyz");
m.put(1, c1);
Map<String, String> c2 = new HashMap<>();
c2.put("Context", "Legacy");
c2.put("Owner", "NotRam");
c2.put("Number", "xyz");
m.put(2, c2);

// you can do like this.
Map result = m.entrySet().stream()
            .filter(x -> x.getValue().entrySet().stream()
                    .anyMatch(y -> y.getKey().equals("Owner") && y.getValue().equals("Ram")))
            .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

System.out.println(result);