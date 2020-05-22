mtutors.forEach((tutorName, subject) -> {
        mstudents.entrySet().stream()
                .filter(entry -> entry.getValue().contains(subject))
                .findFirst()
                .ifPresent(entry -> System.out.println(tutorName + ":" + entry.getKey() + ":" + subject));
    });