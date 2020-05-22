Map<String, String> m1 = new HashMap<>();
    m1.put("x", "1");
    m1.put("y", "2");

    Map<String, String> m2 = new HashMap<>();
    m2.put("x", "1");
    m2.put("y", "4");

    System.out.println(m1.equals(m2)); // false
    System.out.println(m1.keySet().equals(m2.keySet()));  // true