Collection<County> counties = rawCounties.stream()
                                         .collect(Collectors.groupingBy(RawCounty::getCounty,
                                                                        Collectors.mapping(raw -> {
                                                                            County county = new County();
                                                                            county.setState(raw.getState());
                                                                            county.setCounty(raw.getCounty());
                                                                            county.setZipCodes(new HashSet<>(Arrays.asList(raw.getZipCode())));
                                                                            return county;
                                                                        }, Collectors.reducing((c1, c2) -> {
                                                                            c1.getZipCodes()
                                                                              .addAll(c2.getZipCodes());
                                                                            return c1;
                                                                        }))))
                                         .values()
                                         .stream()
                                         .map(Optional::get)
                                         .collect(Collectors.toSet());

Map<Long, County> zipToCounty = new HashMap<>();
counties.forEach(c -> c.getZipCodes().forEach(z -> zipToCounty.put(z, c)));

Map<String, List<Person>> peopleInCounty = persons.stream()
                                                  .collect(Collectors.groupingBy(p -> zipToCounty.get(p.getZipCode())
                                                                                                 .getCounty()));

counties.forEach(c -> c.setAverage(peopleInCounty.get(c.getCounty())
                                                 .stream()
                                                 .mapToInt(Person::getIncome)
                                                 .average()
                                                 .orElse(0)));

counties.forEach(c -> peopleInCounty.get(c.getCounty())
                                    .forEach(p -> p.setAboveAverage(p.getIncome() - c.getAverage())));