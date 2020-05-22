public static void showCourseListDialog() {
    if (courseListDialog == null) {
        courseListDialog = new CourseListFrame();
        courseListDialog.addCourses();// <<---- this is key!
    }
    courseListDialog.pack();
    courseListDialog.setVisible(true);
    courseListDialog.setSize(260, 180);
 }