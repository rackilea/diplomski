result = someList.stream()
                 .filter(i -> i.geFilterField() == someValue)
                 .map(i -> Optional.ofNullable(i.getTargetField())
                                   .orElse(i.getAlterField()))
                 .findFirst()
                 .orElse(null);