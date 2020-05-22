final List<List<String>> collect =
    dataMapList.stream()
               .map(map ->
                    columnsLabel.stream()
                                .map(cl -> cl.getFieldid())
                                .map(id -> String.valueOf(map.get(id)))
                                .collect(Collectors.toList())
               ).collect(Collectors.toList());