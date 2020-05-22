private Course getCourseByName(String name, List<Course> courseList) {

    // This basically filters the list based on your filter criteria and returns the first match,
    // or null if none were found.
    return courseList.stream().filter(course ->
            course.getCourseName().equalsIgnoreCase(name)).findFirst().orElse(null);
}