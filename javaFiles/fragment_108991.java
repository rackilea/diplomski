List<PersonWrapper> resultSet = jrList.stream()
                .map(p -> seniorList.stream()
                        .filter(sr -> p.getName().equals(sr.getName()))
                        .findFirst()
                        .map(q -> new PersonWrapper(p, q))
                        .get())
                .collect(Collectors.toList());