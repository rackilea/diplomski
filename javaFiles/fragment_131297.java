enum Grade {
    A, B, C, UNKNOWN;

    public static Grade fromString(String value) {
        for (Grade grade : values()) {
            if (grade.name().equalsIgnoreCase(value)) {
                return grade;
            }
        }

        return UNKNOWN;
    }
}
class Employee {

    @JsonDeserialize(using = GradeDeserializer.class)
    private Grade grade;
    private String name;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee [grade=" + grade + ", name=" + name + "]";
    }
}