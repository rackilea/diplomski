public boolean addCourse(String course) {
    if (courses.contains(course)) {
        return false;
    }

    return courses.add(course);
}