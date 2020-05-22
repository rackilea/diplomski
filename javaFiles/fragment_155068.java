class Registration {

    @Id private long Id;

    String electiveType;
    LocalDateTime created = LocalDateTime.now();

    Long studentId;
}

public class Student {

    @Id private long Id;

    String userId;
    int matriculationNumber;
    String eMail;
}