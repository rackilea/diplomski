Map<Student, List<Subject>> result = markList
                .stream()
                .collect(Collectors.toMap(
                        Mark::getStudent,
                        v -> new ArrayList<>(singletonList(v.getSubject())),
                        (a, b) -> {a.addAll(b); return a;}));