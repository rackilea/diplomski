@JsonPropertyOrder({"studentId", "studentName", "ctlgMarks"})
class Students {

    private int studentId;
    private String studentName;
    private Marks ctlgMarks;

    // getters, setters, constructors
}

class Marks {

    private int marksId;
    private String markValue;

    @JsonBackReference
    private Set<Students> students;

    // getters, setters, constructors
}