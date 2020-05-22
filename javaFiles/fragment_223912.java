class Student {
    Set<Transcript> transcripts;
}

class Transcript {
    Student student;
    Course course;
    Date subscriptionDate;
}

class Course {
    Set<Transcript> transcripts;
}