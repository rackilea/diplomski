List<Info> dateCounts = ...;
Map<YearMonth, Integer> monthCounts = new TreeMap<>();

for (Info info : dateCounts) {
    YearMonth yearMonth = new YearMonth(info.getLocalDate());
    if (monthCounts does not contains yearMonth) {
        monthCounts.put(yearMonth, info.count);
    } else {
        oldCount = monthCounts.get(yearMonth);
        monthCounts.put(yearMonth, info.count + oldCount);
    }
}

// feel free to output content of monthCounts now.
// And, with TreeMap, the content of monthCounts are sorted