class School {
    //fields

    public School(String id, String name) {
        this.schoolId = id;
        this.schoolName = name;
    }

    @JsonCreator
    public static School create(Map<String, Object> object) {
        return new School((String) object.get("schoolId"), 
                          (String) object.get("schoolName"));
    }

    //getters
}