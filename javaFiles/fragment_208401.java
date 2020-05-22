Map<String, Long> collect = transactions.stream().collect(Collectors.groupingBy(t -> {
    if (t.startsWith("X")) {
        return "X";
    }
    if (t.startsWith("Y")) {
        return "Y";
    }
    if (t.startsWith("Z")) {
        return "Z";
    }
    return "none";
}, Collectors.counting()));