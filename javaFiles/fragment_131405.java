@Test
public void testWriteSchoolsAsJSONWithGsonAndCustomOutput()
        throws Exception {
    final Gson gson = new GsonBuilder().registerTypeAdapter(Student.class,
            new StudentAdapter()).create();

    Student[] students = new Student[2];
    students[0] = new Student("sam", 1);
    students[1] = new Student("tom", 2);

    School school = new School(students);

    final String outputJson = gson.toJson(school);
    System.out.println(outputJson);

    school = gson.fromJson(outputJson, School.class);
    System.out.println(school);
}