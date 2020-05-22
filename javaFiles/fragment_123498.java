@Get ("json")
public Faculty present() throws Exception {
    (...)
    Faculty faculty = new Faculty();
    faculty.setName("...");
    faculty.setPost("...");
    (...)
    return faculty;
}