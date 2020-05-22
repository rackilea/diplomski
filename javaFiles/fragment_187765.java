private Course getCourseByName(String name, List<Course> courseList) {

    // Loop through all courses and compare the name. Return the Course if a match is found or null if not
    for (Course course : courseList) {
        if (name.equalsIgnoreCase(course.getCourseName())) {
            return course;
        }
    }

    return null;
}