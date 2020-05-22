Model m = list.stream()
            .filter(p -> p.name.equals("1"))
            .filter(p -> p.rollNo.equals(1))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Key not found"));

  if (hm.containsKey(m)) {
        System.out.println("hit");
  }