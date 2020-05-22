Map<Long, String> zipToCounty = counties.stream()
                                        .collect(Collectors.toMap(County::getZipCode, County::getCounty));

Map<String, List<Person>> peopleInCounty = persons.stream()
                                                  .collect(Collectors.groupingBy(p -> zipToCounty.get(p.getZipCode())));

Map<String, Double> averagePerCounty = peopleInCounty.entrySet()
                                                     .stream()
                                                     .collect(Collectors.toMap(e -> e.getKey(),
                                                                               e -> e.getValue()
                                                                                     .stream()
                                                                                     .mapToInt(Person::getIncome)
                                                                                     .average()
                                                                                     .orElse(0)));