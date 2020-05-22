private Date findRecordDate(List<DividendEvent> events, Scheme scheme) {
        String name = scheme.getName();
        return events.stream().filter(e -> name.equalsIgnoreCase(e.getScheme().getName()))
                              .map(Di‌​videndEvent::getReco‌​rdDate) 
                              .findFirst().orElse(null);
}