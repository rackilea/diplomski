public class PersonalInfo {
    @JsonView(Views.BasicPersonalInfo.class)
    private String name;

    @JsonView(Views.AcademicPersonalInfo.class)
    String universityName;

    @JsonView(Views.FamilyPersonalInfo.class)
    private String motherName;

    @JsonView(Views.FamilyPersonalInfo.class)
    private String fatherName;
}