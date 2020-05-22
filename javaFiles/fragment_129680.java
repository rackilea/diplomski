Map<String, Map<String, Diagnostic>> map = alerts.stream()
    .collect(Collectors.groupingBy(Alert::getSerie,
        Collectors.toMap(Alert::getRame, e -> new Diagnostic(e.getSerie(), e.getRame()),
            (d1, d2) -> Diagnostic.builder()
                .serie(d1.getSerie())
                .rame(d1.getRame())
                .events(Stream.concat(d1.getEvents().stream(),
                    d2.getEvents().stream()).collect(Collectors.toList()))
                .build())));