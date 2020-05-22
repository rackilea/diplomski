public Map<String, Map<String, Long>> authorFragmentation(List<Commit> commits) {
    return commits.stream()
            .flatMap(c -> c.getChangesList()
                    .stream()
                    .map((Changes ch) -> new String[] { c.getAuthorName(), ch.getPath() }))
            .collect(Collectors.groupingBy(sa -> sa[1], 
                    Collectors.groupingBy(sa -> sa[0], Collectors.counting())));
}