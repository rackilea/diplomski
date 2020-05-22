class Registration {

    @Id private long Id;

    String electiveType;
    LocalDateTime created = LocalDateTime.now();
}

class Student {

    @Id private long Id;

    String userId;
    int matriculationNumber;
    String eMail;
    Set<Registration> registrations = new HashSet<>();
}