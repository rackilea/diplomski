public class Course {
    private List<Prerequisite> prerequisites;

    public boolean canBeTakenBy(Student student) {
        return prerequisites.isEmpty() ||
               prerequisites.stream().anyMatch(p -> p.isFulfilledBy(student));
    }
}

public class Prerequisite {
    private List<Course> requiredCourses;

    public boolean isFulfilledBy(Student student) {
        return requiredCourses.stream().allMatch(student::hasPassed);
    }
}

public class Student {
    private Set<Course> passedCourses;

    public boolean hasPassed(Course course) {
        return passedCourses.contains(course);
    }
}