@Test
public void match_onMistmatchMatchAndNull_ok() {
    Student s1 = new Student("Andrew", "Physics", null);
    Student s2 = new Student("Joe", "Physics", 3.45);
    Student s3 = new Student("Nicki", "Physics", 2.39);

    Student defaults = new Student("Multiple Names", "Multiple Courses", 1.0);

    ObjectMatcher matcher = new ObjectMatcher();
    Student res = matcher.match(Arrays.asList(s1, s2, s3), defaults);

    assertEquals("Multiple Names", res.name);
    assertEquals("Physics", res.course);
    assertEquals(1.0, res.grade.doubleValue(), 0.001);
}