Map<String, Map<String, Optional<Diagnostic>>> map = alerts.stream()
    .collect(Collectors.groupingBy(Alert::getSerie,
        Collectors.groupingBy(Alert::getRame,
            Collectors.mapping(e -> new Diagnostic(e.getSerie(), e.getRame()),
                Collectors.reducing((d1, d2) -> Diagnostic.builder()
                    .serie(d1.getSerie())
                    .rame(d1.getRame())
                    .events(Stream.concat(d1.getEvents().stream(),
                        d2.getEvents().stream()).collect(Collectors.toList()))
                    .build())))));