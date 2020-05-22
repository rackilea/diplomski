List<CsvEntity> resultSet
                = source.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.summingInt(e -> Integer.parseInt(e.getOCCURRENCES()))))
                .entrySet()
                .stream()
                .map(x -> {
                    CsvEntity c = x.getKey();
                    return new CsvEntity(Integer.toString(x.getValue()),
                          c.getSTATUS(), c.getMESSAGE(), c.getSTACK_TRACE());
                }).collect(Collectors.toList());