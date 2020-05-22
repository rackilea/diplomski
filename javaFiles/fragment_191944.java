class CourseItem {
    private String courseName;
    private String courseId; // Or int or whatever

    CourseItem(String courseName,String courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public String toString() { // For display
        return this.courseName;
    }
}