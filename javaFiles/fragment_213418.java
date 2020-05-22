HashMap<Integer,String> studentHash = studentList.stream().collect(
    Collectors.toMap(
        s -> s.studentId, s -> s.studentName,
        (u, v) -> {
            throw new IllegalStateException(
                String.format("Cannot have 2 values (%s, %s) for the same key", u, v)
            );
        }, HashMap::new
    )
);