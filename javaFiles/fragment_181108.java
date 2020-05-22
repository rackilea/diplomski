data.getData()
        .stream()
        .collect(Collectors.groupingBy(Data::getRecieptId))
        .entrySet()
        .stream()
        .map(item -> dataToReadable(item.getValue()))
        .collect(Collectors.toList());