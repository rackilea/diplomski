Map<String,Integer> m=new HashMap<>();
    m.put("foo", 5);
    m.put("bar", 7);
    m.put("baz", 42);
    // {b=49, f=5}
    Map<Character,Integer> m2=PairStream.from(m)
      .mapKey(s->s.charAt(0))
      .toMap(Integer::sum);

    // foo bar
    String str=PairStream.from(m)
      .filterValue(i->i<30)
      .keys().sorted(Comparator.reverseOrder())
      .collect(Collectors.joining(" "));