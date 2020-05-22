class StudentAdapter extends TypeAdapter<Student> {

    @Override
    public void write(final JsonWriter writer, final Student student)
            throws IOException {
        if (student == null) {
            writer.nullValue();
            return;
        }

        writer.beginObject();
        writer.name("student");
        writer.beginObject();
        writer.name("name");
        writer.value(student.getName());
        writer.name("rollNumber");
        writer.value(student.getRollNumber());
        writer.endObject();
        writer.endObject();
    }

    @Override
    public Student read(final JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }

        final Student student = new Student();
        reader.beginObject();
        reader.nextName(); // discard the 'student' wrapper property
        reader.beginObject();
        while (reader.hasNext()) {
            final String attrName = reader.nextName();
            if ("name".equals(attrName)) {
                student.setName(reader.nextString());
            } else if ("rollNumber".equals(attrName)) {
                student.setRollNumber(reader.nextInt());
            }
        }
        reader.endObject();
        reader.endObject();

        return student;
    }
}