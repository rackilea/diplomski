Map<String,Integer> map=new HashMap<>();
    map.put("muhv~", 26);
    map.put("kfool", 3);
    String str = PairStream.from(map)
      .sortedByValue(Comparator.naturalOrder())
      .flatMapToInt((s,i)->s.codePoints().map(c->c^i))
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();