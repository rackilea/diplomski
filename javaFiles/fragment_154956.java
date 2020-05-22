private static Collector<String, List<String>, String> limitingJoin(String delimiter, int limit, String ellipsis) {
    return Collector.of(
                ArrayList::new, 
                (l, e) -> {
                    if (l.size() < limit) l.add(e);
                    else if (l.size() == limit) l.add(ellipsis);
                },
                (l1, l2) -> {
                    l1.addAll(l2.subList(0, Math.min(l2.size(), Math.max(0, limit - l1.size()))));
                    if (l1.size() == limit) l1.add(ellipsis);
                    return l1;
                },
                l -> String.join(delimiter, l)
           );
}