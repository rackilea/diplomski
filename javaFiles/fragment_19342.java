public Map<String,Integer> executeSQL14(List<Record> records) {
    return records.stream()
            .filter(p -> p.getSource().equals("a") || p.getSource().equals("b"))
            .filter(p -> p.getDestination().equals("f") || p.getDestination().equals("h"))
            .filter(p -> p.getExtendedSecurityCheck().equals("n"))
            .collect(Collectors.groupingBy(Record::getDestination, 
                    Collectors.collectingAndThen(Collectors.averagingInt(Record::getWeight), Double::intValue)));
}