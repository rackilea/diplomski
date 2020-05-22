allStudentsWithStatus.stream()
        .sorted(Comparator.comparing(i -> i.getStatus()))
        //other actions
        //.filter(student -> student.getLastName().equals("Иванов"))
        .collect(Collectors.toList());
        //.collect(Collectors.toSet());