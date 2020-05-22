String mostFrequentStream(List<String> elements) {
    Map<String, Long> temp = elements.stream()
            .collect(Collectors.groupingBy(a -> a, Collectors.counting()));


    return new HashSet<>(temp.values()).size() < temp.size() ? 
          null : temp.entrySet()
                     .stream()
                     .max(Map.Entry.comparingByValue())
                     .map(Map.Entry::getKey).get();

}