private void appendConditions(StringBuilder query, StringBuilder... conditions) {
    String ands = Stream.of(conditions)
            .map(StringBuilder::toString)
            .filter(StringUtils::isNotEmpty)
            .map(c -> "(" + c + ")")
            .collect(Collectors.joining(ApplicationConstants.AND));
    if (!ands.isEmpty()) {
        query.append(ApplicationConstants.AND).append(ands);
    }
}