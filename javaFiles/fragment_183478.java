return map.values()
          .stream()
          .filter(x -> x.getSet().stream().anyMatch(t -> t.getCountry().equals(countryname)))
          .map(R::getSet)
          .flatMap(Set::stream)
          .collect(Collectors.toList());