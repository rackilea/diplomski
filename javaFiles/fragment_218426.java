List<T> result = 
            list.stream()
                .collect(groupingBy(T::getSecNumber))
                .values()
                .stream()
                .flatMap(l -> l.stream().anyMatch(e -> e.getType() == Type.NEW) ?
                    l.stream().filter(e -> e.getType() != Type.LEGACY) :
                    l.stream())
                .collect(toList());