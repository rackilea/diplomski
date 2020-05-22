entityList.stream()
          .collect(Collectors.groupingBy(i -> i.getDate().getMonth(),
                                         Collectors.groupingBy(i -> i.getCenterId(),
                                         Collectors.collectingAndThen(Collectors.toList(),
                                                                      l -> {Integer sum = l.stream().collect(Collectors.summingInt(i -> i.getAmount()));
                                                                            Double avg = l.stream().collect(Collectors.averagingDouble(i -> i.getPercent()));
                                                                            return new AbstractMap.SimpleEntry<>(sum, avg);
                                                                            }))))
          .forEach((k, v) -> v.forEach((k1, v1) -> System.out.println(k.toString() + " - " + k1.toString() + " - " + v1.getKey() + " - " + v1.getValue())));