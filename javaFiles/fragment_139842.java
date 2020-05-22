final Map<String, String> mostFrequentCities =
  records.stream()
         .collect(Collectors.groupingBy(
            Record::getZip,
            Collectors.collectingAndThen(
              Collectors.groupingBy(Record::getCity, Collectors.counting()),
              map -> map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey()
            )
         ));