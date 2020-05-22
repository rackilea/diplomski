List<String> list = Arrays.asList("dramatic","slap","chalk","fence","resonant","tin",
                                  "six","labored","spark","treatment","horrible","actually");
Map<LetterGroup, Set<String>> groups = list.stream()
                                           .collect(Collectors.groupingBy(LetterGroup::of,
                                                                          TreeMap::new,
                                                                          Collectors.toCollection(TreeSet::new)));
for (Entry<LetterGroup, Set<String>> entry : groups.entrySet())
    System.out.println(entry);