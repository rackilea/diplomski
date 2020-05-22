public class CustomStudentSerializer extends StdSerializer<List<Student>> {

    public CustomStudentSerializer() {
        this(null);
    }

    public CustomStudentSerializer(Class<List<Student>> t) {
        super(t);
    }

    @Override
    public void serialize(
            List<Student> students,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        List<Student> studs = new ArrayList<>();
        for (Student s : students) {
            s.setGroups(null);
            studs.add(s);
        }
        generator.writeObject(studs);
    }
}