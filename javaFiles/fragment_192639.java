Map<String, Long> map = list.stream()
        .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

List<Map.Entry<String, Long>> result = map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(10)
        .collect(Collectors.toList());