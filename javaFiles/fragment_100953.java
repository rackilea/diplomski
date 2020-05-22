public class Students {

    @JsonProperty(value="studentsjson")
    private List<StudentInfo> studentInfo;
   .....
}

ObjectMapper mapper = new ObjectMapper();
mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

Students students = mapper.readValue(JsonAsString, Students.class);
System.out.println("student is:"+students);