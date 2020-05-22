SortedMap<Month, Integer> m = new SortedEnumMap(Month.class);

for (Month v : Month.values()) {
    m.put(v, v.getValue());
}

System.out.println("firstKey():       " + m.firstKey());
System.out.println("lastKey():        " + m.lastKey());
System.out.println("headMap/June:     " + m.headMap(Month.JUNE));
System.out.println("tailMap/June:     " + m.tailMap(Month.JUNE));
System.out.println("subMap/April-July " + m.subMap(Month.APRIL, Month.JULY));