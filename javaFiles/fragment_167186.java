haulsList 
      .stream()
      .collect(Collectors.groupingBy(HAUL::getSpecie, 
              Collectors.collectingAndThen(Collectors.toList(),
                  list -> {
                     int left = list.stream().mapToInt(HAUL::getFishCount).sum();
                     BigDecimal right = list.stream().map(HAUL::getFishWeight).reduce(BigDecimal.ZERO, (x, y) -> x.add(y));
                    return new AbstractMap.SimpleEntry<>(left, right);
                  })));