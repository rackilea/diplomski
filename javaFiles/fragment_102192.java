public List<String> getDataFromColumn(String columnName, int nth) {
    return IntStream.range(0, rows.size())
                    .filter(n -> n % nth == 0)
                    .mapToObj(rows::get)
                    .map(row -> row.get(headers.indexOf(columnName)))
                    .collect(Collectors.toList());
}